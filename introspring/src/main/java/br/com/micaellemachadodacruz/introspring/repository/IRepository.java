package br.com.micaellemachadodacruz.introspring.repository;
import java.util.List;


public interface IRepository<E> {
    public boolean insert(E entidade);

    public boolean update (E entidade);

    public E findById (int id);

    public List<E> findAll();

    public boolean delete(int id);
}
