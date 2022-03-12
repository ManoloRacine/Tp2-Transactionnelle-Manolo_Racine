import Model.Employee;
import Persistence.LibraryDao;
import Persistence.LibraryDaoJPAH2;
import Service.AdminService;
import Service.EmployeeService;

public class Main {

    public static void main(String[] args) {
        //create a new client and add him to the database
        LibraryDao libraryDao = new LibraryDaoJPAH2() ;
        AdminService adminService = new AdminService(libraryDao) ;
        long libraryId = adminService.createLibrary() ;
        long clientId = adminService.createClient("firstName", "lastName", "password", libraryId) ;
        System.out.println(adminService.getClient(clientId));

        //add a book to the library
        EmployeeService employeeService = new EmployeeService(libraryDao) ;
        employeeService.addBookToLibrary("name", "author", 2002, 200, "genre", libraryId) ;
        System.out.println(adminService.getLibraryWithDocuments(libraryId));
    }
}
