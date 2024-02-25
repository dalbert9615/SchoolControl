package dao;

import java.util.List;

import model.Career;

public interface CareerDAO {
    public String createCareer(Career career);
    public boolean updateCareer(Career career);
    public boolean deleteCareer(int id);
    public Career getCareer(int id);
    public List<Career> getAllCareers();
}
