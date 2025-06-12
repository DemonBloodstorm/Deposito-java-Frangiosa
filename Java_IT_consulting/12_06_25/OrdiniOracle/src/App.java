import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static Connection getConnessione() {
        String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        String user = "hr";
        String password = "hr";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Errore connessione: " + e);
            return null;
        }
    }

    public static int creaCliente(Connection conn, Scanner sc) {
        try {
            sc.nextLine(); // flush
            System.out.print("Inserisci ID cliente: ");
            int id_cliente = sc.nextInt();
            sc.nextLine(); // flush

            System.out.print("Inserisci nome cliente: ");
            String nome = sc.nextLine();

            System.out.print("Inserisci email cliente: ");
            String email = sc.nextLine();

            System.out.print("Inserisci telefono cliente: ");
            String telefono = sc.nextLine();

            String sql = "INSERT INTO clienti (id_cliente, nome, email, telefono) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id_cliente);
                ps.setString(2, nome);
                ps.setString(3, email);
                ps.setString(4, telefono);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Cliente inserito con successo.");
                    return id_cliente;
                } else {
                    System.out.println("Inserimento cliente fallito.");
                }
            }
        } catch (Exception e) {
            System.out.println("Errore inserimento cliente: " + e.getMessage());
        }
        return -1; // errore
    }

    public static void aggiungiOrdine(Connection conn, Scanner sc) {
    try {
        // 1. Mostrare i clienti esistenti
        String sqlClienti = "SELECT id_cliente, nome FROM clienti";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sqlClienti)) {
            System.out.println("\n--- CLIENTI REGISTRATI ---");
            int count = 0;
            while (rs.next()) {
                count++;
                System.out.printf("ID: %d | Nome: %s\n", rs.getInt("id_cliente"), rs.getString("nome"));
            }

            if (count == 0) {
                System.out.println(" Nessun cliente trovato. Aggiungi prima un cliente.");
                return;
            }
        }

        // 2. Selezione dell'ID cliente
        System.out.print("Inserisci l'ID del cliente a cui vuoi aggiungere l'ordine: ");
        int id_cliente = sc.nextInt();
        sc.nextLine(); // flush

        // 3. Inserimento ordine
        System.out.print("Inserisci ID ordine: ");
        int id_ordine = sc.nextInt();
        sc.nextLine();

        String data_ordine = LocalDate.now().toString();
        String sqlOrdine = "INSERT INTO ordini (id_ordine, id_cliente, data_ordine, stato) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
        try (PreparedStatement ps = conn.prepareStatement(sqlOrdine)) {
            ps.setInt(1, id_ordine);
            ps.setInt(2, id_cliente);
            ps.setString(3, data_ordine);
            ps.setString(4, "In consegna");
            ps.executeUpdate();
            System.out.println(" Ordine aggiunto con successo.");
        }

    } catch (Exception e) {
        System.out.println("Errore aggiunta ordine: " + e);
    }
}


    public static void stampaOrdini(Connection conn) {
        String query = "SELECT * FROM ordini";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                System.out.printf("ID Ordine: %d | Cliente: %d | Data: %s | Stato: %s\n",
                        rs.getInt("id_ordine"),
                        rs.getInt("id_cliente"),
                        rs.getDate("data_ordine"),
                        rs.getString("stato"));
            }
        } catch (Exception e) {
            System.out.println("Errore stampa ordini: " + e);
        }
    }

    public static void aggiornaStato(Connection conn, Scanner sc) {
        try {
            System.out.print("Inserisci ID ordine: ");
            int id_ordine = sc.nextInt();
            sc.nextLine();
            System.out.print("Inserisci nuovo stato: ");
            String stato = sc.nextLine();

            String update = "UPDATE ordini SET stato = ? WHERE id_ordine = ?";
            try (PreparedStatement ps = conn.prepareStatement(update)) {
                ps.setString(1, stato);
                ps.setInt(2, id_ordine);
                int count = ps.executeUpdate();
                if (count > 0)
                    System.out.println("Stato aggiornato.");
                else
                    System.out.println("Ordine non trovato.");
            }
        } catch (Exception e) {
            System.out.println("Errore aggiornamento stato: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = getConnessione();
        if (conn == null) return;

        int ultimoCliente = -1;

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Aggiungi cliente");
            System.out.println("2. Aggiungi ordine (solo se esiste almeno un cliente)");
            System.out.println("3. Stampa ordini");
            System.out.println("4. Aggiorna stato ordine");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    ultimoCliente = creaCliente(conn, sc);
                    break;
                case 2:
                    aggiungiOrdine(conn, sc);
                    break;
                case 3:
                    stampaOrdini(conn);
                    break;
                case 4:
                    aggiornaStato(conn, sc);
                    break;
                case 0:
                    System.out.println("Uscita...");
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        System.out.println("Errore chiusura connessione");
                    }
                    return;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}

