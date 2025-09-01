package com.turktrust.football_hibernate.database;
import com.turktrust.football_hibernate.entities.BaseEntities;
import com.turktrust.football_hibernate.entities.Footballers;
import com.turktrust.football_hibernate.entities.Teams;
import com.turktrust.football_hibernate.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class DatabaseManager {


    public static <T extends BaseEntities> void save(List<T> entitiesToSave) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            for (T entity : entitiesToSave){
                session.save(entity);
            }
            session.getTransaction().commit();
            System.out.println("Ekleme işlemi başarıyla tamamlandı");
        } catch (HibernateException e) {
            System.out.println("Ekleme işlemi yapılırken hata oluştu" + e);
            if (session.getTransaction() == null){
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    public static <T extends BaseEntities> void update(List<T> entitiesToUpdate) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            for (T entity : entitiesToUpdate){
                session.merge(entity);
            }

            session.getTransaction().commit();
            System.out.println("Güncelleme işlemi başarıyla tamamlandı");

        } catch (Exception e) {
            System.out.println("Güncelleme işlemi yapılırken hata oluştu " + e);
            if (session.getTransaction() == null){
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
    }



    public static <T extends BaseEntities> List<T> getTable(Class<T> clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<T> resultList = null;

        try {
            resultList = session.createQuery("From " + clazz.getSimpleName(), clazz).list();
            System.out.println(clazz.getSimpleName() + " Table");

//            for (T BaseEntities : resultList) {
//                System.out.println(BaseEntities);
//            }
        } catch (Exception e) {
            System.out.println("Tablo çekme yapılırken hata oluştu " + e);

        } finally {
            if (session != null){
                session.close();
            }
        }
        return resultList;
    }



    // Generic bir metod tanımlıyoruz. T burada herhangi bir Entity sınıfı olabilir
    public static <T> List<T> getFilteredData(Class<T> entityClass, Map<String, Object> filters) {
        // Sonuçları tutacak boş bir liste oluşturuyoruz.
        List<T> dataList = List.of();
        // Hibernate oturumunu açıyoruz.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // CriteriaBuilder: SQL benzeri sorgu oluşturmak için kullanılır.
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            // Criteria sorgusu tanımlanıyor. Hangi entity için olduğunu bilmiyoruz, o yüzden generic T ile.
            CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass);
            // Sorguda kullanılacak "root" (ana tablo) tanımlanıyor.
            Root<T> root = query.from(entityClass);

            // WHERE şartlarını tutacak predicate (koşul) listesi oluşturuluyor.
            List<Predicate> predicates = new ArrayList<>();
            // filters map'inde dolaşıyoruz (örneğin: "name" → "Sebastian").
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                // Her bir filtreyi Predicate (koşul) olarak ekliyoruz.
                // Örn: root.get("name") = "Sebastian"
                predicates.add(criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue()));
            }

            // Tüm filtreleri tek bir AND bloğunda birleştirip WHERE şartına ekliyoruz.
            query.select(root).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            // Sorguyu çalıştırıyoruz ve sonucu listeye atıyoruz.
            dataList = session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println("Veri çekilirken hata oluştu: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return dataList;
    }





    public static <T extends BaseEntities> void delete(List<T> entitiesToDelete) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            for (T entity : entitiesToDelete){
                if(entity.getId() != null){
                    session.delete(entity);
                    session.getTransaction().commit();
                    System.out.println("Silme işlemi başarıyla tamamlandı");
                }
            }

        } catch (HibernateException e) {
            System.out.println("Silme işlemi yapılırken hata oluştu" + e);
            if (session.getTransaction() == null){
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null){
                session.close();
            }

        }
    }





    public static BaseEntities findByIdWithCriteria(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Teams> query = criteriaBuilder.createQuery(Teams.class);
        Root<Teams> root = query.from(Teams.class);
        query.select(root).where(criteriaBuilder.equal(root.get("id"), id));

        return session.createQuery(query).uniqueResult();
    }


//    public static List<BaseEntities> getDataWithCriteria(BaseEntities baseEntities, String columnName, Object object) {
//
//
//        List<BaseEntities> dataList = List.of();
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<BaseEntities> query = criteriaBuilder.createQuery(BaseEntities.class);
//            Root<BaseEntities> root = query.from(BaseEntities.class);
//            query.select(root).where(criteriaBuilder.equal(root.get(columnName), object));
//            dataList = session.createQuery(query).getResultList();
//
//
//        }catch (Exception e){
//            System.out.println("Criteria ile veri çekilirken hata oluştu " + e);
//
//        } finally {
//            if (session != null){
//                session.close();
//            }
//        }
//        return dataList;
//    }




















}


