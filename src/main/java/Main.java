import Persistence.LibraryDao;
import Persistence.LibraryDaoJPAH2;
import Service.AdminService;

public class Main {

    public static void main(String[] args) {
        LibraryDao libraryDao = new LibraryDaoJPAH2() ;
        AdminService adminService = new AdminService(libraryDao) ;
        adminService.createLibrary() ;
        long clientId = adminService.createClient("firstName", "lastName", "password", 1) ;
        System.out.println(adminService.getClient(clientId));


    }
}
