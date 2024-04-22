package DAO;

import Models.Product.Pencil;

import java.util.ArrayList;

public class PencilDAO implements DAOInterface<Pencil> {
    public static PencilDAO getInstance(){
        return new PencilDAO();
    }
    @Override
    public int insert(Pencil pencil) {
        return 0;
    }

    @Override
    public int update(Pencil pencil) {
        return 0;
    }

    @Override
    public int delete(Pencil pencil) {
        return 0;
    }

    @Override
    public ArrayList<Pencil> selectAll() {
        return null;
    }

    @Override
    public Pencil selectById(String id) {
        return null;
    }

    @Override
    public ArrayList<Pencil> selectByCondition(String condition) {
        return null;
    }
}
