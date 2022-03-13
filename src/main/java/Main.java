import Persistence.LibraryDao;
import Persistence.LibraryDaoJPAH2;
import Service.AdminService;
import Service.ClientService;
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
        employeeService.addBookToLibrary("name", "author", 2020, 200, "testg", libraryId) ;
        employeeService.addBookToLibrary("testn", "testa", 2020, 100, "genre", libraryId) ;
        employeeService.addBookToLibrary("testn2", "testa", 2021, 101, "testg", libraryId) ;
        System.out.println(adminService.getLibraryWithDocuments(libraryId));

        //document research by title
        ClientService clientService = new ClientService(libraryDao) ;
        System.out.println(clientService.researchDocumentByTitle("name", libraryId));
        System.out.println(clientService.researchDocumentByTitle("nam", libraryId));

        //document research by author
        System.out.println(clientService.researchDocumentByAuthor("testa", libraryId));

        //document research by year
        System.out.println(clientService.researchDocumentByYear(2020, libraryId));

        //book research by category
        System.out.println(clientService.researchBooksByCategory("testg", libraryId));

    }
}
