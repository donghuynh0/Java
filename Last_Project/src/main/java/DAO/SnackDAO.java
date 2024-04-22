package DAO;

import Models.Product.Snack;

import java.util.ArrayList;

public class SnackDAO implements DAOInterface<Snack>{
    public static NoteBookDAO getInstance(){
        return new NoteBookDAO();
    }
    @Override
    public int insert(Snack snack) {
        return 0;
    }

    @Override
    public int update(Snack snack) {
        return 0;
    }

    @Override
    public int delete(Snack snack) {
        return 0;
    }

    @Override
    public ArrayList<Snack> selectAll() {
        return null;
    }

    @Override
    public Snack selectById(String id) {
        return null;
    }

    @Override
    public ArrayList<Snack> selectByCondition(String condition) {
        return null;
    }
}
