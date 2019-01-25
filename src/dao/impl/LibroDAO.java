package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAO;
import dao.ILibroDAO;
import models.Libro;

public class LibroDAO extends AbstractDAO implements ILibroDAO {
	
	private static final String CREATE_LIBRO = "INSERT INTO libro (titolo, descrizione, autore_id) VALUES (?,?,?)";
	
    private static final String READ_LIBRO = "SELECT * FROM libro WHERE id = ?";

    private static final String READ_ALL_LIBRI = "SELECT * FROM libro";
    
    private static final String UPDATE_LIBRO = "UPDATE libro SET titolo=? , descrizione=? WHERE id = ?";
    
    private static final String DELETE_LIBRO = "DELETE FROM libro WHERE id = ?";
    
    private static final String LIBRO_BY_AUTOREID = "SELECT FROM libro WHERE id =?"; 
    
    @Override
    public List<Libro> getAllLibri() {        
    	
    	List<Libro> result = new ArrayList<>();

        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(READ_ALL_LIBRI);
                ResultSet rs = ps.executeQuery();
            ) {        	
            while (rs.next()) {
                Libro r = new Libro(rs.getString("titolo"), rs.getString("descrizione"), rs.getInt("autore_id"));
                r.setId(rs.getInt("id"));
                result.add(r);
            }   
            } catch (Exception e) {
            e.printStackTrace();
        }        
        return result;
    }

	@Override
	public Libro getLibro(int libroId) {
		Libro libro = null;
		ResultSet rs = null;
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(READ_LIBRO);				
			) {
			ps.setInt(1, libroId);
			rs = ps.executeQuery();
			if (rs.next() && rs!=null) {
				libro = new Libro (rs.getString("titolo"), rs.getString("descrizione"), rs.getInt("autore_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {        	
	            try {	
	                rs.close();	
	            } catch (SQLException e) {	
	                e.printStackTrace();	
	            }	
	        }	
		}		
		return libro;
	}

	@Override
	public void createLibro(Libro libro) {
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(CREATE_LIBRO);
				){
			
			ps.setString(1, libro.getTitolo());
			ps.setString(2, libro.getDescrizione());
			ps.setInt(3, libro.getAutoreId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
	}


	@Override
	public void updateLibro(Libro libro) {
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(UPDATE_LIBRO);
			){
			
			ps.setString(1, libro.getTitolo());
			ps.setString(2, libro.getDescrizione());
			ps.setInt(3, libro.getId());
			ps.executeUpdate();		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
	}


	@Override
	public void deleteLibro(int libroId) {
		
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(DELETE_LIBRO);
			){
			
			ps.setInt(1, libroId);
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		} 
	}

	@Override
	public List<Libro> getLibriByAutoreId(int autoreId) {

    	List<Libro> result = new ArrayList<>();

        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(LIBRO_BY_AUTOREID);
                ResultSet rs = ps.executeQuery();
            ) {        	
            while (rs.next()) {
                Libro r = new Libro(rs.getString("titolo"), rs.getString("descrizione"), rs.getInt("autore_id"));
                r.setId(rs.getInt("id"));
                result.add(r);
            }   
            } catch (Exception e) {
            e.printStackTrace();
        }        
        return result;
    }
		

   

    

}
