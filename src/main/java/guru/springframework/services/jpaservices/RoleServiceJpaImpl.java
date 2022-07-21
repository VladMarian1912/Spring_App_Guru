package guru.springframework.services.jpaservices;

import guru.springframework.domain.security.Role;
import guru.springframework.services.RoleService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class RoleServiceJpaImpl extends AbstractJpaDaoService implements RoleService {

    @Override
    public List<?> listAll() {
        EntityManager em = entityManagerFactory.createEntityManager();

        return em.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(Role.class, id);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        Role saveRole = em.merge(domainObject);
        em.getTransaction().commit();

        return saveRole;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Role.class, id));
        em.getTransaction().commit();
    }
}
