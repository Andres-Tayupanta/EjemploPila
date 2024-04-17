import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Historial {
    private JTextField textField1;
    private JButton regresarButton;
    private JPanel Ventana;
    private JTextArea textArea1;
    private JButton buscarButton;
    private JButton ingresarButton;

    private Pila pila= new Pila();

    public  Historial(){


        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pila.apilar(textField1.getText());
                textArea1.setText(pila.toString());
                textField1.setText("");
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JOptionPane.showMessageDialog(null,"La URL anterior fue: "+pila.desapilar());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String urlBuscada = JOptionPane.showInputDialog(null, "Ingrese la URL que desea buscar:");
                    if (urlBuscada != null && !urlBuscada.isEmpty()) {
                        boolean encontrada = pila.buscarUrl(urlBuscada);
                        if (encontrada) {
                            JOptionPane.showMessageDialog(null, "La URL " + urlBuscada + " está en el historial.");
                        } else {
                            JOptionPane.showMessageDialog(null, "La URL " + urlBuscada + "no está en el historial.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor ingresa una URL válida.");
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "Error al buscar la URL: " + exc.getMessage());
                }

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Historial");
        frame.setContentPane(new Historial().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
