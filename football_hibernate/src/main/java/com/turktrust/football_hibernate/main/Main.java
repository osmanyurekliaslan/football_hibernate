package com.turktrust.football_hibernate.main;



import com.turktrust.football_hibernate.database.DatabaseManager;

import com.turktrust.football_hibernate.entities.BaseEntities;

import com.turktrust.football_hibernate.entities.Footballers;

import com.turktrust.football_hibernate.entities.TeamHistory;

import com.turktrust.football_hibernate.entities.Teams;

import com.turktrust.football_hibernate.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;



import javax.management.Query;

import java.time.LocalDate;

import java.util.*;



import static com.turktrust.football_hibernate.database.DatabaseManager.update;


public class Main {

    public static void main(String[] args) {


        //delete metodu deneme örneği

//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.beginTransaction();
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<BaseEntities> query = criteriaBuilder.createQuery(BaseEntities.class);
//        Root<Teams> root = query.from(Teams.class);
//        query.select(root).where(criteriaBuilder.equal(root.get("name"), "Trabzonspor"));
////        query.select(root).where(criteriaBuilder.equal(root.get("name"), "Fenerbahçe"));
//
//        List<BaseEntities> listToDelete = DatabaseManager.getDataWithCriteria(query);
//
//        DatabaseManager.delete(listToDelete);






            //veriatabanından kritere göre veri çekme örneği
//
//        Map<String, Object> filters = new HashMap<>();
//        filters.put("age", "26");
//
//
//        List<Footballers> footballersList = DatabaseManager.getFilteredData(Footballers.class, filters);
//        for (Footballers footballer : footballersList) {
//            System.out.println(footballer);
//        }
        
        
        


            //rollback() deneme

//        List<BaseEntities> savedList = new ArrayList<>();
//
//        Teams fenerbahce = new Teams("Fenerbahçe", "FCB", "Türkiye");
//
//        Teams samsunspor = new Teams("Samsunspor", "SAM", "Türkiye");
//
//        savedList.addAll(List.of(fenerbahce,samsunspor));
//
//        DatabaseManager.save(savedList);


            //Kayıt işlemi


//        List<BaseEntities> savedList = new ArrayList<>();
//
//
//
//        Teams fenerbahce = new Teams("Fenerbahçe", "FB", "Türkiye");
//
//        Teams galatasaray = new Teams("Galatasaray", "GS", "Türkiye");
//
//        Teams besiktas = new Teams("Beşiktaş", "BJK", "Türkiye");
//
//        Teams trabzonspor = new Teams("Trabzonspor", "TS", "Türkiye");
//
//        savedList.addAll(List.of(fenerbahce,galatasaray,besiktas,trabzonspor));
//
//
//
//        Footballers szymanski = new  Footballers("Sebastian", "Szymanski", 26, 100, "Poland", fenerbahce);
//
//        Footballers talisca = new Footballers("Anderson", "Talisca", 31, 100, "Brazil", fenerbahce);
//
//        Footballers orkun = new Footballers("Orkun", "Kökçü", 24, 100, "Türkiye", besiktas);
//
//        Footballers mert = new Footballers("Mert", "Günok", 36, 100, "Türkiye", besiktas);
//
//        Footballers osimhen = new Footballers("Victor", "Osimhen", 26, 100, "Nigeria", galatasaray);
//
//        Footballers icardi = new Footballers("Mauro", "İcardi", 32, 100, "Argentina", galatasaray);
//
//        Footballers jDuran = new Footballers("Jhon","Duran", 21,100,"Colombia", fenerbahce);
//
//        savedList.addAll(List.of(szymanski,talisca,orkun,mert,osimhen,icardi,jDuran));
//
//
//
//        TeamHistory teamHistory = new TeamHistory(LocalDate.of(2020,1,1), LocalDate.of(2020,12,12), fenerbahce, szymanski);
//
//        TeamHistory teamHistory2 = new TeamHistory(LocalDate.of(2020,1,1), LocalDate.of(2020,12,12), fenerbahce, talisca);
//
//        TeamHistory teamHistory3 = new TeamHistory(LocalDate.of(2020,1,1), LocalDate.of(2020,12,12), besiktas, orkun);
//
//        TeamHistory teamHistory4 = new TeamHistory(LocalDate.of(2020,1,1), LocalDate.of(2020,12,12), besiktas, mert);
//
//        TeamHistory teamHistory5 = new TeamHistory(LocalDate.of(2020,1,1), LocalDate.of(2020,12,12), galatasaray, osimhen);
//
//        TeamHistory teamHistory6 = new TeamHistory(LocalDate.of(2020,1,1), LocalDate.of(2020,12,12), galatasaray, icardi);
//
//        TeamHistory teamHistory7 = new TeamHistory(LocalDate.of(2020,1,1), LocalDate.of(2020,12,12), fenerbahce, jDuran);
//
//        savedList.addAll(List.of(teamHistory,teamHistory2,teamHistory3,teamHistory4,teamHistory5,teamHistory6,teamHistory7));
//
//
//
//        DatabaseManager.save(savedList);


            //Güncelleme işlemi


//        List<BaseEntities> updatedList = new ArrayList<>();
//
//        List<Teams> teamList = DatabaseManager.getTable(Teams.class);
//
//        List<Footballers> footballarList = DatabaseManager.getTable(Footballers.class);
//
//        System.out.println(teamList);
//
//        for (Teams teams : teamList){
//            if (teams.getName().equals("Galatasaray") && teams.getCountry().equals("France")){
//                teams.setCountry("Türkiye");
//                updatedList.add(teams);
//            }
//            if (teams.getName().equals("Fenerbahçe") && teams.getCountry().equals("Türkiye")) {
//                teams.setShortname("FB");
//                updatedList.add(teams);
//            }
//        }
//
//        for (Footballers footballers : footballarList){
//            if (footballers.getName().equals("Victor") && footballers.getSurname().equals("Osimhen")){
//                footballers.setPrice(0);
//                updatedList.add(footballers);
//            }
//            if (footballers.getSurname().equals("Duran") && footballers.getName().equals("Jhon")){
//                footballers.setPrice(500);
//                updatedList.add(footballers);
//            }
//            if (footballers.getName().equals("Orkun") && footballers.getSurname().equals("Kökçü")){
//                footballers.setPrice(100);
//                updatedList.add(footballers);
//            }
//        }
//
//        DatabaseManager.update(updatedList);


    }
}

