/*
 * CC BY-NC-SA 4.0
 */
package repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 * @param <T>
 */
public abstract class Dao<T>
        implements IDao<T> {

    public static final String DB = "contratos";

    @Override
    public void saveOrUpdate(T e, boolean save) throws Exception {

        if (save)
        {

            // Insert a new register
            // try-with-resources
            try (PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getSaveStatment(),
                            Statement.RETURN_GENERATED_KEYS))
            {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs insertion into the database
                preparedStatement.executeUpdate();

                // Retrieve the generated primary key
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                // Moves to first retrieved data
            } catch (Exception ex)
            {
                System.out.println(">> " + ex);

            }

        } else
        {
            // Update existing record
            try (PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getUpdateStatment()))
            {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs the update on the database
                preparedStatement.executeUpdate();

            } catch (Exception ex)
            {
                System.out.println("Exception: " + ex);

            }
        }

    }

    @Override
    public T findByPk(T e) throws Exception {

        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindByPkStatment()))
        {

            // Assemble the SQL statement with the id
            composeFindByPkStatement(preparedStatement, e);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);
            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next())
            {
                return extractObject(resultSet);
            }

        } catch (Exception ex)
        {
            System.out.println("Exception: " + ex);

        }
        return null;
    }

    @Override
    public boolean deleteByPk(T e) throws Exception {

        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getDeleteByPkStatment()))
        {

            // Assemble the SQL statement with the id
            composeDeleteByPkStatement(preparedStatement, e);
            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);
            // Performs the query on the database

            // Returns the respective object if exists
            return preparedStatement.execute();

        } catch (Exception ex)
        {
            System.out.println("Exception: " + ex);

        }

        return false;
    }

    @Override
    public List<T> findAll() throws Exception {

        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindAllStatment()))
        {

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object
            return extractObjects(resultSet);

        } catch (Exception ex)
        {
            System.out.println("Exception: " + ex);

        }
        return null;
    }

    @Override
    public List<T> extractObjects(ResultSet resultSet) {
        List<T> objects = new ArrayList<>();

        try
        {
            while (resultSet.next())
            {
                objects.add(extractObject(resultSet));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objects.isEmpty() ? null : objects;
    }

}
