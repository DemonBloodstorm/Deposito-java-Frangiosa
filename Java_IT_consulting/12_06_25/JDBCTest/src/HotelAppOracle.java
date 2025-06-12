import java.sql.*;
import java.util.Scanner;

public class HotelAppOracle {
    private static final String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci nome utente: ");
        String username = sc.nextLine();
        System.out.print("Inserisci la tua password: ");
        String password = sc.nextLine();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {// Tenta di stabilire una connessione con il database
                                                                                 
            System.out.println("Connessione al database riuscita!");

            while (true) {// se riesce a connettersi mostra il menù e chiede all'utente di effettuare una scelta
                          
                System.out.println("\n--- MENU ---");
                System.out.println("1. Inserisci ospite");
                System.out.println("2. Effettua prenotazione");
                System.out.println("3. Visualizza prenotazioni");
                System.out.println("0. Esci");
                System.out.print("Scelta: ");
                int scelta = sc.nextInt();
                sc.nextLine(); // Pulisce il buffer

                switch (scelta) {// La scelta dell'utente viene gestita con un switch
                    case 1 -> inserisciOspite(conn, sc);
                    case 2 -> effettuaPrenotazione(conn, sc);
                    case 3 -> visualizzaPrenotazioni(conn);
                    case 0 -> {
                        System.out.println("Uscita...");
                        return;
                    }
                    default -> System.out.println("Scelta non valida.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Errore di connessione: " + e.getMessage());
        }
    }

    private static void inserisciOspite(Connection conn, Scanner sc) throws SQLException { // Permette di inserire un ospite definito dall'utente
                                                                                           
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Cognome: ");
        String cognome = sc.nextLine();

        String sql = "INSERT INTO Utenti (nome, cognome) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, cognome);
            pstmt.executeUpdate();
            System.out.println("Ospite inserito con successo.");
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento dell'ospite: " + e.getMessage());
        }
    }

    private static void effettuaPrenotazione(Connection conn, Scanner sc) {

        try {
            // Mostra le camere disponibili
            String sqlCamere = "SELECT ID, NUMERO, DESCRIZIONE FROM camere";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlCamere)) {
                System.out.println("Camere disponibili:");
                while (rs.next()) {
                    System.out.printf("ID: %d - Numero: %d - %s%n",
                            rs.getInt("ID"),
                            rs.getInt("NUMERO"),
                            rs.getString("DESCRIZIONE"));

                }
            } catch (SQLException e) {
                System.err.println("Errore durante la visualizzazione delle camere: " + e.getMessage());
            }
            System.out.print("ID utente: ");
            int idUtente = sc.nextInt();
            System.out.print("ID camera: ");
            int idCamera = sc.nextInt();
            sc.nextLine(); // pulisce buffer

            String sqlPrenotazione = "INSERT INTO Prenotazioni (id_utente, id_camera, data_prenotazione) VALUES (?, ?, SYSDATE)";// inserisce una prenotazione
            try (PreparedStatement pstmt = conn.prepareStatement(sqlPrenotazione)) {
                pstmt.setInt(1, idUtente);
                pstmt.setInt(2, idCamera);
                int righeInserite = pstmt.executeUpdate();
                if (righeInserite > 0) {
                    System.out.println("Prenotazione effettuata con successo.");
                } else {
                    System.out.println("Errore nell'effettuare la prenotazione.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Errore durante la prenotazione: " + e.getMessage());
        }
    }

    private static void visualizzaPrenotazioni(Connection conn) throws SQLException { // Visualizza le prenotazioni effettuate
                                                                                      
        String sql = """
                    SELECT p.id, u.nome, u.cognome, c.numero, c.descrizione, p.data_prenotazione
                    FROM Prenotazioni p
                    JOIN Utenti u ON p.id_utente = u.id
                    JOIN Camere c ON p.id_camera = c.id
                """;
        ;
        // Esegue la query SQL e ottiene i risultati
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("Prenotazione #%d - %s %s - Camera %d (%s) - Data: %s%n",
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getInt("numero"),
                        rs.getString("descrizione"),
                        rs.getDate("data_prenotazione"));
            }
        }
    }
}
