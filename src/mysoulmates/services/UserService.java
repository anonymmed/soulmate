/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.services;

import mysoulmates.utils.Bd;
import mysoulmates.entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ss
 */
public class UserService {
    
    static Bd ds = Bd.getInstance();
    
    public static void signIn(User u) {
        try {
            String req = "INSERT INTO `user`(`fname`, `lname`, `email`, `password`, `role`, `username`, `phoneNumber`, `gender`, `image`, `age`, `address`, `date_SU`, `nbr_like`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, u.getFname());
            ste.setString(2, u.getLname());
            ste.setString(3, u.getEmail());
            ste.setString(4, u.getPassword());
            ste.setInt(5, 1);
            ste.setString(6, u.getUsername());
            ste.setInt(7, u.getPhoneNumber());
            ste.setString(8, u.getGender());
            ste.setString(9, u.getImage());
            ste.setInt(10, u.getAge());
            ste.setString(11, u.getAddress());
            ste.setString(12, u.getDate_SU());
            ste.setInt(13, 0);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int login(User u) {
        int count=-1;
    
        try {
        
            String loginQry = "SELECT * FROM user WHERE username = ? AND password= ?";
              PreparedStatement ste = ds.getConnection().prepareStatement(loginQry);
            ste.setString(1, u.getUsername());
     
           ste.setString(2, u.getPassword());
            ResultSet rs = ste.executeQuery();
            while(rs.next()){
              
              u.setId(rs.getInt(14));
              
                    count=rs.getInt(5);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public User findById(Integer id)  {
        String req = "select * from user where id = ?";
        User u = null;
        
         try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setInt(1, id);
            ResultSet resultSet = ste.executeQuery();
            while (resultSet.next()) {
            u = new User(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10),resultSet.getString(11),resultSet.getString(12),resultSet.getInt(13),resultSet.getInt(14));
            }
       } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    public String findEmail(int id ) throws SQLException
    {
        String req="select email from user where id=?";
                String email=null;
                PreparedStatement ste  = ds.getConnection().prepareStatement(req);
                ste.setInt(1, id);
                ResultSet rs =ste.executeQuery();
                while (rs.next())
                {
                    email=rs.getString(email);
                }
                return email;
    }    
       public static void Update(User u,int id) {
        try {
            String req = "UPDATE `user` SET `fname`=?,`lname`=?,`email`=?,`password`=?,`role`=?,`username`=?,`phoneNumber`=?,`gender`=?,`image`=?,`age`=?,`address`=?,`date_SU`=?,`nbr_like`=? WHERE `id`=?";
            
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, u.getFname());
            ste.setString(2, u.getLname());
            ste.setString(3, u.getEmail());
            ste.setString(4, u.getPassword());
            ste.setInt(5, 1);
            ste.setString(6, u.getUsername());
            ste.setInt(7, u.getPhoneNumber());
            ste.setString(8, u.getGender());
            ste.setString(9, u.getImage());
            ste.setInt(10, u.getAge());
            ste.setString(11, u.getAddress());
            ste.setString(12, u.getDate_SU());
            ste.setInt(13, 0);
            ste.setInt(14,id);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       /*
       ##############~~Mohamed's Functions~~###################"
       */
           public static int getType(User c1)
    {       
            int type=-1;
            String req = "select role from user where email = ?";
                try {
                        PreparedStatement statement0 = ds.getConnection().prepareStatement(req);
            statement0.setString(1, c1.getEmail());
            ResultSet rs = statement0.executeQuery();
          while(rs.next())
          {
              type=rs.getInt("role");
          }

        } catch (SQLException ex) {
                                  Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

        }
return type;
    }
    
    public static void likeClient(User c1,User c2)
    {
        
        
        String req0 = "select nbr_like from user where email = ?";
        
        String req = "INSERT INTO likes (liked,liked_by) SELECT * FROM (SELECT ?,?) AS tmp WHERE NOT EXISTS (SELECT liked,liked_by FROM likes WHERE liked = ? and liked_by = ?) LIMIT 1";
        String req1= "select liked_by from likes where liked = ?";
        try {
            PreparedStatement statement0 = ds.getConnection().prepareStatement(req0);
            statement0.setString(1, c1.getEmail());
            ResultSet rs = statement0.executeQuery();
                                        int likes=0;
            while(rs.next())
            {
            likes =rs.getInt("nbr_like");

            }
            if (likes<User.MAX || getType(c1) == 1)
            {
            PreparedStatement statement = ds.getConnection().prepareStatement(req);
            statement.setString(1, c2.getEmail());
            statement.setString(2, c1.getEmail());
            statement.setString(3, c2.getEmail());
            statement.setString(4, c1.getEmail());

            statement.executeUpdate();
        
        String req2="update user set nbr_like=nbr_like+1 where email = ? and nbr_like < ?";
        statement = ds.getConnection().prepareStatement(req2);
        statement.setString(1, c1.getEmail());
                statement.setInt(2,User.MAX);
            statement.executeUpdate();
            PreparedStatement statement2 = ds.getConnection().prepareStatement(req1);
            statement2.setString(1,c1.getEmail());
            ResultSet rs2 = statement2.executeQuery();
            while(rs2.next())
            {
                System.out.println("matching  : "+rs2.getString("liked_by"));
                break;
                //3ayet lel fonction taa notification
            }

            }
        
        } catch (SQLException ex ) {
            System.out.println(ex.getMessage());
//Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

        }
        
    }
    
    
    public static ResultSet DisplayLikes(User c) throws Exception
    {
      //  List<User> l1 = new ArrayList<>();
        ResultSet rs=null;
        String req = "select * from user u inner join likes l on u.email=l.liked";
        try
        {
                    PreparedStatement statement = ds.getConnection().prepareStatement(req);
             rs = statement.executeQuery();
            /*while(rs.next())
            {
                
                l1.add(new User(rs.getString("fname"),rs.getString("lname"),rs.getString("liked"),"*****",1,rs.getString("username"),rs.getInt("phoneNumber"),rs.getString("genfer"),rs.getString("image"),rs.getInt("age"),rs.getString("address"),"chihemek",1));
            }*/
            
            
        }
        
        catch(SQLException ex)
        {
                                  Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

        }
        if (rs== null)
        {
            throw new Exception("error no data in result set");
        }
        return rs;
    }
    
    public static void DeleteLike(User c1,User c2)
    {
        String req  = "DELETE from likes where liked  = ? and liked_by = ?  ";
        
        try{
                    PreparedStatement statement = ds.getConnection().prepareStatement(req);
                    statement.setString(1, c2.getEmail());
                    statement.setString(2, c1.getEmail());
                    statement.executeUpdate();
                    
        }
        catch(SQLException ex)
        {
     Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
             public static ArrayList<User> displayMatching(User u,User u2)
         {
             List<User>usl = new ArrayList<User>();
             String req="Select * from user";
        try {
            PreparedStatement statement = ds.getConnection().prepareStatement(req);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                
                usl.add(new User(rs.getString("fname"), rs.getString("lname"),rs.getString("email"),rs.getString("password") , 0,rs.getString("username"), 0,rs.getString("gender"), rs.getString("image"), rs.getInt("age"),rs.getString("address"), rs.getString("date_su"),rs.getInt("nbr_like")));

                        }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (ArrayList<User>) usl;
         }

    
}
