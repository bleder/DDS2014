package ar.edu.repo;

import ar.edu.domain.Materia;
import ar.edu.repo.AbstractRepoHibernate;
import org.apache.commons.collections.Closure;
import org.hibernate.Query;
import org.hibernate.Session;

@SuppressWarnings("all")
public class RepoHibernateMaterias extends AbstractRepoHibernate<Materia> {
  public Materia get(final Long id, final boolean deep) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void deleteAll() {
    final Closure _function = new Closure() {
      public void execute(final Object session) {
        Query _createQuery = ((Session) session).createQuery("delete from Materia");
        _createQuery.executeUpdate();
      }
    };
    this.executeBatch(_function);
  }
}
