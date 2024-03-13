/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.squarepeace.nnppss;

import com.squarepeace.nnppss.Utilities;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    private DefaultTableModel originalModel; // Variable para almacenar el modelo de datos original

    // Declaración del TableRowSorter
    private TableRowSorter<DefaultTableModel> rowSorter;

    private final Utilities utilities; // Utilizamos una variable final para guardar la instancia de Utilities

    // Variable para controlar el estado de la descarga
    private boolean downloadPaused = false;

    // Variable para controlar si hay descargas en curso
    private boolean downloading = false;

    public Frame(Utilities utilities) { // Modifica el constructor para aceptar una instancia de Utilities
        this.utilities = utilities; // Asigna la instancia recibida a la variable de clase
        initComponents(); // Asegúrate de llamar al constructor de la superclase si es necesario
        jbResumeAndPause.setEnabled(false); // Inicialmente deshabilitado
        // jrdPsvita como seleccionado por defecto
        jrbPsvita.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgConsoles = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jbsearch = new javax.swing.JLabel();
        jbRefresh = new javax.swing.JButton();
        jtfSearch = new javax.swing.JTextField();
        jcbRegion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbSetting = new javax.swing.JButton();
        jrbPsvita = new javax.swing.JRadioButton();
        jrbPsp = new javax.swing.JRadioButton();
        jpbDownload = new javax.swing.JProgressBar();
        jbResumeAndPause = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NNPPSS");

        jPanel1.setName("NNPPSS"); // NOI18N

        jbsearch.setText("Search:");

        jbRefresh.setText("Refresh");
        jbRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefreshActionPerformed(evt);
            }
        });

        jtfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSearchKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfSearchKeyReleased(evt);
            }
        });

        jcbRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbRegionItemStateChanged(evt);
            }
        });

        jtData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtDataMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtData);

        jLabel1.setText("Region: ");

        jLabel2.setText("Console:");

        jbSetting.setText("Setting");
        jbSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSettingActionPerformed(evt);
            }
        });

        bgConsoles.add(jrbPsvita);
        jrbPsvita.setText("Psvita");
        jrbPsvita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPsvitaActionPerformed(evt);
            }
        });

        bgConsoles.add(jrbPsp);
        jrbPsp.setText("Psp");
        jrbPsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jrbPsvita)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbPsp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jcbRegion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbsearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jbRefresh)
                                .addGap(18, 18, 18)
                                .addComponent(jbSetting)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1231,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jcbRegion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbsearch)
                                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbRefresh)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jbSetting)
                                        .addComponent(jrbPsvita)
                                        .addComponent(jrbPsp))
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                                .addContainerGap()));

        jpbDownload.setStringPainted(true);

        jbResumeAndPause.setText("Pause");
        jbResumeAndPause.setActionCommand(":p");
        jbResumeAndPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResumeAndPauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 3, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jpbDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 561,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbResumeAndPause)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jpbDownload, javax.swing.GroupLayout.DEFAULT_SIZE, 45,
                                                Short.MAX_VALUE)
                                        .addComponent(jbResumeAndPause))
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbRefreshActionPerformed

        fillTableAndComboBox("Psvita");
    }// GEN-LAST:event_jbRefreshActionPerformed

    private void jtfSearchKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jtfSearchKeyPressed
        String searchText = jtfSearch.getText().trim();
        filtrarTablaPorTextoYRegion(searchText, (String) jcbRegion.getSelectedItem());
    }// GEN-LAST:event_jtfSearchKeyPressed

    private void jcbRegionItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jcbRegionItemStateChanged

        String selectedRegion = (String) jcbRegion.getSelectedItem();
        System.out.println("Selected Region: " + selectedRegion); // Mensaje de depuración
        if (selectedRegion != null) {
            filtrarTablaPorTextoYRegion(jtfSearch.getText().trim(), selectedRegion);
        }
    }// GEN-LAST:event_jcbRegionItemStateChanged

    private void jtfSearchKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jtfSearchKeyReleased

        String searchText = jtfSearch.getText().trim();
        filtrarTablaPorTextoYRegion(searchText, (String) jcbRegion.getSelectedItem());

    }// GEN-LAST:event_jtfSearchKeyReleased

    private void jtDataMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jtDataMousePressed

        int selectedRow = jtData.getSelectedRow();
        if (selectedRow != -1) { // Verificar si se ha seleccionado una fila válida
            // Obtener el índice de la fila seleccionada en el modelo de la vista
            int modelRowIndex = jtData.convertRowIndexToModel(selectedRow);

            // Obtener el modelo de tabla filtrado a través del TableRowSorter
            DefaultTableModel filteredModel = (DefaultTableModel) jtData.getModel();

            // Obtener el valor de la columna "PKG direct link" en la fila seleccionada
            Object pkgDirectLinkValue = filteredModel.getValueAt(modelRowIndex,
                    getColumnIndexByName("PKG direct link"));

            // Verificar si el valor de pkgDirectLinkValue es MISSING o CART ONLY
            if (pkgDirectLinkValue.equals("MISSING")) {
                // Mostrar mensaje de que el juego no se puede descargar porque el link de
                // descarga no está registrado
                JOptionPane.showMessageDialog(this,
                        "You cannot download this game because the download link is not registered.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (pkgDirectLinkValue.equals("CART ONLY")) {
                // Mostrar mensaje de que el juego solo se encuentra en formato físico
                JOptionPane.showMessageDialog(this, "This game is available in cart only.", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (pkgDirectLinkValue.equals("NOT REQUIRED")) {
                // Mostrar mensaje de que el juego solo se encuentra en formato físico
                JOptionPane.showMessageDialog(this, "NO download required", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (jrbPsp.isSelected()) {
                {
                    Object nameValue = filteredModel.getValueAt(modelRowIndex, getColumnIndexByName("Name"));
                    Object fileSizeValue = filteredModel.getValueAt(modelRowIndex, getColumnIndexByName("File Size"));

                    String pkgDirectLink = pkgDirectLinkValue.toString();
                    String fileName = pkgDirectLink.substring(pkgDirectLink.lastIndexOf("/") + 1);

                    // Mostrar el cuadro de diálogo de confirmación para descargar el archivo
                    int option = JOptionPane.showConfirmDialog(this,
                            "¿You want to download " + nameValue + ", Size is " + fileSizeValue + "?",
                            "Download File",
                            JOptionPane.YES_NO_OPTION);

                    // Verificar la opción seleccionada por el usuario
                    if (option == JOptionPane.YES_OPTION) {
                        // Lógica para descargar el archivo aquí
                        downloadFileInBackground(pkgDirectLink, fileName, fileName, null, "Psp");
                    }
                }
            } else if (jrbPsvita.isSelected()) {
                // El juego está disponible para descarga
                Object nameValue = filteredModel.getValueAt(modelRowIndex, getColumnIndexByName("Name"));
                Object fileSizeValue = filteredModel.getValueAt(modelRowIndex, getColumnIndexByName("File Size"));
                Object zRIFValue = filteredModel.getValueAt(modelRowIndex, getColumnIndexByName("zRIF"));
                String pkgDirectLink = pkgDirectLinkValue.toString();
                String fileName = pkgDirectLink.substring(pkgDirectLink.lastIndexOf("/") + 1);
                String zRIF = zRIFValue.toString();

                // Mostrar el cuadro de diálogo de confirmación para descargar el archivo
                int option = JOptionPane.showConfirmDialog(this,
                        "¿You want to download " + nameValue + ", Size is " + fileSizeValue + "?",
                        "Download File",
                        JOptionPane.YES_NO_OPTION);

                // Verificar la opción seleccionada por el usuario
                if (option == JOptionPane.YES_OPTION) {
                    // Lógica para descargar el archivo aquí
                    downloadFileInBackground(pkgDirectLink, fileName, fileName, zRIF, "Psvita");
                }
            }
        }
    }// GEN-LAST:event_jtDataMousePressed

    private void jbResumeAndPauseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbResumeAndPauseActionPerformed
        // Cambiar el estado de la descarga
        downloadPaused = !downloadPaused;
        // Actualizar el texto del botón
        if (downloadPaused) {
            jbResumeAndPause.setText("Resume");
        } else {
            jbResumeAndPause.setText("Pause");
        }
    }// GEN-LAST:event_jbResumeAndPauseActionPerformed

    private void jbSettingActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbSettingActionPerformed
        Config config = new Config();
        config.setLocationRelativeTo(null);
        config.setResizable(false);
        config.setVisible(true);

        // metodo para cargar los valores de las url en los campos de texto desde el
        // archivo config.properties
        config.loadValues();

    }// GEN-LAST:event_jbSettingActionPerformed

    private void jrbPsvitaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jrbPsvitaActionPerformed
        fillTable();
    }// GEN-LAST:event_jrbPsvitaActionPerformed

    private void jrbPspActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jrbPspActionPerformed
        fillTable();
    }// GEN-LAST:event_jrbPspActionPerformed

    // si el usuario selecciona la consola psp, se cargan los datos de la consola
    // psp, si selecciona psvita, se cargan los datos de psvita por medio de los
    // metodos fillTableAndComboBoxPsp y fillTableAndComboBoxVita usando
    // JradioButton para seleccionar la consola "jrbPsp" y "jrbPsvita

    public void fillTable() {
        if (jrbPsp.isSelected()) {
            fillTableAndComboBox("Psp");
        } else if (jrbPsvita.isSelected()) {
            fillTableAndComboBox("Psvita");
        }
    }

    public void fillTableAndComboBox(String console) {
        // Crear un nuevo modelo de tabla usando los datos del archivo TSV
        try {
            if (console.equals("Psp")) {
                originalModel = utilities.readTSV(utilities.TSV_PSP);
            } else if (console.equals("Psvita")) {
                originalModel = utilities.readTSV(utilities.TSV_VITA);
            }
        } catch (IOException e) {
            // Manejar cualquier excepción que pueda ocurrir al leer el archivo TSV
            e.printStackTrace();
            // Si ocurre un error al leer el archivo, salir del método
            return;
        }

        // Crear un nuevo modelo de tabla para almacenar las filas que cumplen con el criterio
        DefaultTableModel filteredModel = new DefaultTableModel();

        // Obtener los nombres de las columnas del modelo original
        Vector<String> columnIdentifiers = new Vector<>();
        for (int i = 0; i < originalModel.getColumnCount(); i++) {
            columnIdentifiers.add(originalModel.getColumnName(i));
        }
        // Establecer los nombres de las columnas en el modelo filtrado
        filteredModel.setColumnIdentifiers(columnIdentifiers);

        // Iterar sobre las filas del modelo original
        for (int i = 0; i < originalModel.getRowCount(); i++) {
            Object fileSizeValue = originalModel.getValueAt(i, getColumnIndexByName("File Size"));
            // Verificar si el valor de "File Size" no está vacío, es distinto de null y mayor que 0
            if (fileSizeValue != null && !fileSizeValue.toString().isEmpty()
                    && Long.parseLong(fileSizeValue.toString()) > 0) {
                // Obtener los datos de la fila actual como un array de objetos
                Object[] rowData = new Object[originalModel.getColumnCount()];
                for (int j = 0; j < originalModel.getColumnCount(); j++) {
                    rowData[j] = originalModel.getValueAt(i, j);
                }
                // Convertir el tamaño del archivo en la fila actual
                rowData[getColumnIndexByName("File Size")] = utilities.convertFileSize(fileSizeValue);
                // Agregar la fila al modelo filtrado
                filteredModel.addRow(rowData);
            }
        }

        // Asignar el nuevo modelo filtrado a la tabla
        jtData.setModel(filteredModel);

        // Crear el TableRowSorter si no existe
        rowSorter = new TableRowSorter<>(filteredModel);
        jtData.setRowSorter(rowSorter);

        // Obtener el número de columnas
        int regionColumnIndex = jtData.getColumn("Region").getModelIndex();

        // Verificar si la columna de la región existe
        if (regionColumnIndex != -1) {
            // Crear un conjunto para almacenar valores únicos de la columna de la región
            Set<String> regionSet = new HashSet<>();

            // Iterar sobre las filas para obtener los valores únicos de la región
            for (int row = 0; row < filteredModel.getRowCount(); row++) {
                // Obtener el valor de la región en la fila actual
                String region = (String) filteredModel.getValueAt(row, regionColumnIndex);

                // Agregar el valor al conjunto
                regionSet.add(region);
            }

            // Limpiar el JComboBox
            jcbRegion.removeAllItems();
            // Agregar la opción para mostrar todas las regiones
            jcbRegion.addItem("All regions");

            // Agregar los elementos únicos al JComboBox
            for (String region : regionSet) {
                jcbRegion.addItem(region);
            }

        } else {
            System.out.println("The region column does not exist in the table.");
        }
    }

    private void filtrarTablaPorTextoYRegion(String searchText, String region) {
        System.out.println("Search Text: " + searchText);
        System.out.println("Region: " + region);
        
        // Crear un RowFilter para filtrar por el texto ingresado y la región
        // seleccionada
        RowFilter<DefaultTableModel, Integer> rowFilterByText = null;
        RowFilter<DefaultTableModel, Integer> rowFilterByRegion = null;
        try {
            // Filtrar por texto ingresado
            rowFilterByText = RowFilter.regexFilter("(?i)" + searchText); // Ignore case
            System.out.println("Row Filter By Text: " + rowFilterByText);
            // Filtrar por región seleccionada si no se selecciona "Todas las regiones"
            if (!region.equals("All regions")) {
                rowFilterByRegion = RowFilter.regexFilter("(?i)" + region, getColumnIndexByName("Region"));
                System.out.println("Row Filter By Region: " + rowFilterByRegion);
            }

            // Combinar los filtros
            List<RowFilter<DefaultTableModel, Integer>> filters = new ArrayList<>();
            if (rowFilterByText != null)
                filters.add(rowFilterByText);
            if (rowFilterByRegion != null)
                filters.add(rowFilterByRegion);

            RowFilter<DefaultTableModel, Integer> combinedRowFilter = RowFilter.andFilter(filters);

            // Establecer el RowFilter en el TableRowSorter
            rowSorter.setRowFilter(combinedRowFilter);
        } catch (java.util.regex.PatternSyntaxException e) {
            e.printStackTrace(); // Imprimir la traza de la excepción para depuración
            // Si hay un error en la expresión regular, simplemente no aplicamos ningún
            // filtro
            rowSorter.setRowFilter(null);
            return;
        }
    }

    private int getColumnIndexByName(String columnName) {
        for (int i = 0; i < originalModel.getColumnCount(); i++) {
            if (originalModel.getColumnName(i).equals(columnName)) {
                return i;
            }
        }
        return -1; // Si no se encuentra la columna, retornar -1
    }

    public void downloadFileInBackground(String fileURL, String localFilePath, String fileName, String zRIF,
            String Console) {
        // Hilo de descarga para no bloquear la interfaz de usuario
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Establecer la variable de descarga en true
                downloading = true;
                // Verificar si el archivo ya existe
                File file = new File(localFilePath);
                if (file.exists()) {
                    JOptionPane.showMessageDialog(Frame.this,
                            "The file already exists. There is no need to download it again.");
                    return null; // Salir si el archivo ya existe
                }

                // Habilitar el botón jbResumeAndPause
                jbResumeAndPause.setEnabled(true);

                // Verificar si las carpetas db y games existen, si no, crearlas
                File dbFolder = new File("db");
                File gamesFolder = new File("games");
                if (!dbFolder.exists()) {
                    dbFolder.mkdir();
                }
                if (!gamesFolder.exists()) {
                    gamesFolder.mkdir();
                }
                long bytesDownloaded = 0;
                try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
                        FileOutputStream fileOutputStream = new FileOutputStream(localFilePath)) {

                    byte dataBuffer[] = new byte[1024];
                    int bytesRead;

                    // Si el archivo ya existe, saltar al final de este
                    if (file.exists()) {
                        bytesDownloaded = file.length();
                        in.skip(bytesDownloaded);
                    }

                    long fileSize = utilities.getFileSize(fileURL);

                    // Leer y escribir datos del archivo
                    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                        // Si la descarga está pausada, esperar
                        while (downloadPaused) {
                            Thread.sleep(1000); // Esperar 1 segundo antes de verificar de nuevo
                        }

                        fileOutputStream.write(dataBuffer, 0, bytesRead);
                        bytesDownloaded += bytesRead;

                        // Calcular y publicar el progreso
                        int progress = (int) (bytesDownloaded * 100 / fileSize);
                        publish(progress);
                    }
                } catch (IOException e) {
                    // Manejar la excepción
                    e.printStackTrace(); // Imprimir la traza de la excepción para depuración
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                // Actualizar la barra de progreso con el último valor publicado
                int progress = chunks.get(chunks.size() - 1);
                jpbDownload.setValue(progress);
            }

            @Override
            protected void done() {
                // Establecer la variable de descarga en false cuando la descarga haya terminado
                downloading = false;

                // Desabilitar el botón jbResumeAndPause
                jbResumeAndPause.setEnabled(false);
                // Verificar la extensión del archivo descargado
                String extension = localFilePath.substring(localFilePath.lastIndexOf(".") + 1).toLowerCase();
                switch (extension) {
                    case "tsv":

                        switch (localFilePath) {
                            case "db/PSV_GAMES.tsv":

                                // Mover el archivo a la carpeta "db"
                                utilities.moveFile(localFilePath,
                                        "db/" + localFilePath.substring(localFilePath.lastIndexOf("/") + 1));
                                JOptionPane.showMessageDialog(Frame.this, "Database loaded");
                                fillTableAndComboBox("Psvita");

                                break;
                            case "db/PSP_GAMES.tsv":
                                utilities.moveFile(localFilePath,
                                        "db/" + localFilePath.substring(localFilePath.lastIndexOf("/") + 1));
                                JOptionPane.showMessageDialog(Frame.this, "Database loaded");
                                // fillTableAndComboBoxPSP();
                                break;
                            default:
                                break;
                        }
                        break;
                    case "pkg":

                        // Mover el archivo a la carpeta "games"
                        utilities.moveFile(localFilePath,
                                "games/" + localFilePath.substring(localFilePath.lastIndexOf("/") + 1));
                        JOptionPane.showMessageDialog(Frame.this, "PKG download completed.");
                        String command = utilities.buildCommand(fileName, zRIF, Console);
                        utilities.runCommandWithLoadingMessage(command);
                        break;
                    default:
                        // No hacer nada si la extensión no está definida
                        break;
                }

                // Notificar al usuario que la descarga ha finalizado
                // JOptionPane.showMessageDialog(Frame.this, "Descarga completada.");
                // fillTableAndComboBox();
            }
        };

        // Ejecutar el SwingWorker
        worker.execute();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgConsoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JButton jbResumeAndPause;
    private javax.swing.JButton jbSetting;
    private javax.swing.JLabel jbsearch;
    private javax.swing.JComboBox<String> jcbRegion;
    private javax.swing.JProgressBar jpbDownload;
    private javax.swing.JRadioButton jrbPsp;
    private javax.swing.JRadioButton jrbPsvita;
    private javax.swing.JTable jtData;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
