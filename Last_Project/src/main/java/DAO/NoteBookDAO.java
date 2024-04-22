package DAO;

import Models.Product.NoteBook;

import java.util.ArrayList;

public class NoteBookDAO implements DAOInterface<NoteBook> {

    public static NoteBookDAO getInstance(){
        return new NoteBookDAO();
    }
    @Override
    public int insert(NoteBook noteBook) {
        return 0;
    }

    @Override
    public int update(NoteBook noteBook) {
        return 0;
    }

    @Override
    public int delete(NoteBook noteBook) {
        return 0;
    }

    @Override
    public ArrayList<NoteBook> selectAll() {
        return null;
    }

    @Override
    public NoteBook selectById(String id) {
        return null;
    }

    @Override
    public ArrayList<NoteBook> selectByCondition(String condition) {
        return null;
    }
}
