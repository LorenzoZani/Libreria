package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAO;
import dao.IAutoreDAO;
import models.Autore;


public class AutoreDAO extends AbstractDAO implements IAutoreDAO {
	// La query per l'inserimento di un nuovo autore 
    private static final String CREATE_QUERY = "INSERT INTO autore (nome, cognome) VALUES (?,?)";
    // La query per la lettura di un singolo autore. 
    private static final String AUTORE_BY_ID_QUERY = "SELECT * FROM autore WHERE id = ?";
    // La query per la lettura di tutti gli autori. 
    private static final String LIST_QUERY = "SELECT * FROM autore";
    // La query per l'aggiornamento di un singolo cliente. 
    private static final String UPDATE_QUERY = "UPDATE autore SET nome=? , cognome=? WHERE id = ?";
    // La query per la cancellazione di un singolo cliente. 
    private static final String DELETE_QUERY = "DELETE FROM autore WHERE id = ?";
	

	@Override
	public List<Autore> getAllAutori() {
		List<Autore> result= new ArrayList<>();
		 try (
	                Connection c = getConnection();
	                PreparedStatement ps = c.prepareStatement(LIST_QUERY);
	                ResultSet rs = ps.executeQuery();
	            ) {
	            
	            while (rs.next()) {
	                Autore r = new Autore(rs.getString("nome"), rs.getString("cognome"));
	                r.setId(rs.getInt("id"));
	                result.add(r);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
		

	@Override
	public Autore getAutore(int autoreId) {
		Autore autore=null;
		ResultSet rs = null;
		try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(AUTORE_BY_ID_QUERY);
            ) {
            ps.setInt(1, autoreId);
            rs = ps.executeQuery();
            if (rs.next() && rs != null) {
                autore = new Autore(rs.getString("nome"), rs.getString("cognome"));
            } 
            
            }catch (Exception e) {
            e.printStackTrace();
        }finally {
        	try {
            rs.close();
        	} catch (Exception rse) {
        		rse.printStackTrace();
        	}
        }
		return autore;
    }


	@Override
	public void createAutore(Autore autore) {
		try (
	                Connection c = getConnection();
	                PreparedStatement ps = c.prepareStatement(CREATE_QUERY);
	            ) {
	            ps.setString(1, autore.getNome());
	            ps.setString(2, autore.getCognome());
	            ps.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	        	
	}

	@Override
	public void updateAutore(Autore autore) {
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(UPDATE_QUERY);
				){
			ps.setString(1, autore.getNome());
			ps.setString(2, autore.getCognome());
			ps.setInt(3, autore.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAutore(int id) {
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(DELETE_QUERY);
				){
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
