package TestDatabaseUtil;

import DAO.PenDAO;
import Models.Product.Pen;

import java.util.ArrayList;

public class TestPenDAO {
    public static void main(String[] args) {
        // test insert into mysql table
//        Pen pen_01 = new Pen("Pen01","ABC","VN","2023-01-01",
//                "CD",20.00,"Blue","C");
//        Pen pen_02 = new Pen("Pen02","CBA","VN","2023-02-02",
//                "CD",20.00,"Red","D");
//
//        PenDAO.getInstance().insert(pen_01);
//        PenDAO.getInstance().insert(pen_02);

        // test update into mysql table
//        Pen pen_01_update = new Pen("Pen01","ABC","VN","2023-01-01",
//                "CD",20.00,"Yellow","C");
//        PenDAO.getInstance().update(pen_01_update);

        // test delete into mysql table
//        Pen pen_01_del = new Pen("Pen01","ABC","VN","2023-01-01",
//               "CD",20.00,"Yellow","C");
//        Pen pen_02_del = new Pen("Pen02","CBA","VN","2023-02-02",
//                "CD",20.00,"Red","D");
//        PenDAO.getInstance().delete(pen_01_del);
//        PenDAO.getInstance().delete(pen_02_del);


//        Pen pen_01 = new Pen("P_01","Elegant Writer","Germany","2023-04-01","Stationery World Inc.",
//                15.99,"Midnight Blue","Fountain Pen");
//        Pen pen_02 = new Pen("P_02","Tech Precision","Japan","2024-01-15","Precision Instruments Ltd.",
//                18.50,"Graphite Black","Rollerball");
//        Pen pen_03 = new Pen("P_03","Classic Nib","France","2023-11-20","Classic Stationery Co.",
//                22.00,"Burgundy","Dip Pen");
//        Pen pen_04 = new Pen("P_04","Office Mate","USA","2023-03-05","Office Supplies Inc.",
//                3.99,"Blue","Ballpoint");
//        Pen pen_05 = new Pen("P_05","Sketch Master","South Korea","2022-12-01","Art Supplies World.",
//                25.99,"Jet Black","Brush Pen");
//        Pen pen_06 = new Pen("P_06","Executive Gold","Italy","2024-02-10","Luxury Writing Instruments.",
//                120.00,"Emerald Green","Fountain Pen");
//
//        PenDAO.getInstance().insert(pen_01);
//        PenDAO.getInstance().insert(pen_02);
//        PenDAO.getInstance().insert(pen_03);
//        PenDAO.getInstance().insert(pen_04);
//        PenDAO.getInstance().insert(pen_05);
//        PenDAO.getInstance().insert(pen_06);


        // test select all data from sql
//        ArrayList<Pen> penTable = PenDAO.getInstance().selectAll();
//        for (Pen pen : penTable){
//            System.out.println(pen);
//        }


        // test select by id
        System.out.println(PenDAO.getInstance().selectById("P_01"));

    }
}
