package com.project.views;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.project.controller.FacultyTableController;
import com.project.controller.HyperlinkTableController;
import com.project.controller.MediaTableController;
import com.project.controller.PartnerTableController;
import com.project.controller.StudentTableController;
import com.project.controller.ViewerProjectTableController;
import com.project.entity.Faculty;
import com.project.entity.Student;
import com.project.tablemodel.FacultyListModel;
import com.project.tablemodel.StudentListModel;

/**
 *
 * @author gyanpatra
 */
public class ProjectDetailsEdit extends javax.swing.JFrame implements KeyListener{

	String projectId;
	int btnSaveCounter = 0;
	File file;

	
	private ViewerProjectTableController projectTableController;
	private PartnerTableController partnerTableController;
	private FacultyTableController facultyTableController;
	private StudentTableController studentTableController;

	private HyperlinkTableController associatedTableController;
	private HyperlinkTableController directTableController;
	private MediaTableController mediaTableController;
	
	private StudentListModel studentModel;
	private FacultyListModel advisorModel;
	//private List<Student> studentList;
	private ArrayList<String> listStudentId;
	private ArrayList<String> listStudentName;
	private ArrayList<String> listAdvisorId;
	private ArrayList<String> listAdvisorName;
	private ArrayList<String> listPartnerName;
	private ArrayList<String> listMediaName;
	private ArrayList<String> listMediaPath;
	
	DefaultTableModel studentTableModel;
	DefaultTableModel advisorTableModel;
	DefaultTableModel partnerTableModel;
	DefaultTableModel mediaTableModel;
    /**
     * Creates new form ProjectDetailsForm
     */
	public ProjectDetailsEdit(String projectId) {
		this.projectId = projectId;

		initComponents();
		projectTableController = new ViewerProjectTableController(this,
				projectId);
		partnerTableController = new PartnerTableController(this, projectId);
		 facultyTableController = new FacultyTableController(this, projectId);
		 studentTableController = new StudentTableController(this, projectId);
		//
		associatedTableController = new HyperlinkTableController(this, projectId, "associated");
		directTableController = new HyperlinkTableController(this, projectId, "direct");
		 mediaTableController = new MediaTableController(this, projectId);
		//
		addJTables();

		// initComboBox();
	}
    public void addJTables() {
    	listAdvisorId = new ArrayList<String>();
		listAdvisorName = new ArrayList<String>();
		
		listStudentId = new ArrayList<String>();
		listStudentName = new ArrayList<String>();
		
		listPartnerName = new ArrayList<String>();
		
		listMediaName = new ArrayList<String>();
		listMediaPath = new ArrayList<String>();
		
    	studentTableModel = (DefaultTableModel) tableStudent.getModel();
    	advisorTableModel = (DefaultTableModel) tableAdvisor.getModel();
    	mediaTableModel = (DefaultTableModel) tableMedia.getModel();
    	partnerTableModel = (DefaultTableModel) tablePartners.getModel();
    	
    	tablePartners = new JTable(partnerTableController.getTableModel());
    	tablePartners.removeColumn(tablePartners.getColumn("project_id"));
    	tablePartners.getColumn("partnerName").setHeaderValue("Name");
    	for (int i = 0; i < tablePartners.getRowCount(); i++) {
    		partnerTableModel.addRow(new Object[]{tablePartners.getValueAt(i,0)});
		}
		
		
    	tableStudent =new JTable(studentTableController.getTableModel());
    	tableStudent.removeColumn(tableStudent.getColumn("student_id"));
    	tableStudent.getColumn("name").setHeaderValue("Student");
    	
    	for (int i = 0; i < tableStudent.getRowCount(); i++) {
    		studentTableModel.addRow(new Object[]{tableStudent.getValueAt(i,0)});
		}
    	
    	tableAdvisor =new JTable(facultyTableController.getTableModel());
    	tableAdvisor.removeColumn(tableAdvisor.getColumn("faculty_id"));
    	tableAdvisor.getColumn("name").setHeaderValue("Advisor");
    	
    	for (int i = 0; i < tableAdvisor.getRowCount(); i++) {
    		advisorTableModel.addRow(new Object[]{tableAdvisor.getValueAt(i,0)});
		}
    	
    	tableMedia =new JTable(mediaTableController.getTableModel());
    	System.out.println("Table Media :"+tableMedia.getColumn("name"));
    	//tableAdvisor.removeColumn(tableAdvisor.getColumn(""));
    	tableMedia.getColumn("name").setHeaderValue("Name");
    	tableMedia.getColumn("path").setHeaderValue("Path");
    	
    	for (int i = 0; i < tableMedia.getRowCount(); i++) {
    		System.out.println(tableMedia.getValueAt(i,0));
    		mediaTableModel.addRow(new Object[]{tableMedia.getValueAt(i,0),tableMedia.getValueAt(i,1)});
		}
		
		
		tableAssociatedHL = new JTable(associatedTableController.getTableModel());
		tableAssociatedHL.removeColumn(tableAssociatedHL.getColumn("project_id"));
		tableAssociatedHL.removeColumn(tableAssociatedHL.getColumn("id"));
		tableAssociatedHL.getColumn("hyperlink").setHeaderValue("Path");
		scrollPaneAssociated.setViewportView(tableAssociatedHL);
		
		
		tableDirectHL = new JTable(directTableController.getTableModel());
		tableDirectHL.removeColumn(tableDirectHL.getColumn("project_id"));
		tableDirectHL.removeColumn(tableDirectHL.getColumn("id"));
		tableDirectHL.getColumn("hyperlink").setHeaderValue("Path");
		scrollPaneDirect.setViewportView(tableDirectHL);

	}

    public ProjectDetailsEdit() {
		this("02");
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        mainScroll = new javax.swing.JScrollPane();
        jLabel6 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        panelProject = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox();
        lblTheme = new javax.swing.JLabel();
        txtTheme = new javax.swing.JTextField();
        lblStartDate = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        dateStartDate = new com.toedter.calendar.JDateChooser();
        dateEndDate = new com.toedter.calendar.JDateChooser();
        panelLinkMedia = new javax.swing.JTabbedPane();
        paneAssociatedLink = new javax.swing.JPanel();
        lblAssociatedHyperlink = new javax.swing.JLabel();
        btnAddAssociatedLink = new javax.swing.JButton();
        btnDeleteAssociatedLink = new javax.swing.JButton();
        scrollPaneAssociated = new javax.swing.JScrollPane();
        tableAssociatedHL = new javax.swing.JTable();
        paneDirecLink = new javax.swing.JPanel();
        lblDirectHyperLink = new javax.swing.JLabel();
        btnAddDirectLink = new javax.swing.JButton();
        btnDeleteDirectLink = new javax.swing.JButton();
        scrollPaneDirect = new javax.swing.JScrollPane();
        tableDirectHL = new javax.swing.JTable();
        paneMedia = new javax.swing.JPanel();
        lblMedia = new javax.swing.JLabel();
        scrollPaneMedia = new javax.swing.JScrollPane();
        tableMedia = new javax.swing.JTable();
        btnAddMedia = new javax.swing.JButton();
        btnDeleteMedia = new javax.swing.JButton();
        panelTeam = new javax.swing.JTabbedPane();
        panelAdvisor = new javax.swing.JPanel();
        lblAdvisor = new javax.swing.JLabel();
        btnAddAdvisor = new javax.swing.JButton();
        scrollPaneAdvisor = new javax.swing.JScrollPane();
        tableAdvisor = new javax.swing.JTable();
        btnDeleteAdvisor = new javax.swing.JButton();
        panelStudents = new javax.swing.JPanel();
        lblStudents = new javax.swing.JLabel();
        btnAddStudent = new javax.swing.JButton();
        scrollPaneStudents = new javax.swing.JScrollPane();
        tableStudent = new javax.swing.JTable();
        btnDeleteStudent = new javax.swing.JButton();
        panelPartners = new javax.swing.JPanel();
        lblPartners = new javax.swing.JLabel();
        btnAddPartner = new javax.swing.JButton();
        scrollPanePartners = new javax.swing.JScrollPane();
        tablePartners = new javax.swing.JTable();
        btnDeletePartner = new javax.swing.JButton();
        panelScopeLocation = new javax.swing.JTabbedPane();
        paneScope = new javax.swing.JPanel();
        txtScopeofWork = new javax.swing.JTextField();
        paneLocation = new javax.swing.JPanel();
        txtLocationPrototype = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        panelLogo = new javax.swing.JPanel();
        
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Frugal_Blk_BriteRed_small.jpg")));
        panelLogo.setBackground(new java.awt.Color(255, 255, 255));
        
        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
            		.addGap(0, 0, Short.MAX_VALUE)
            		.addComponent(lblLogo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
            		//.addGap(0, 12, Short.MAX_VALUE)
            		.addComponent(lblLogo)
                //.addGap(0, 12, Short.MAX_VALUE)
            		)
        );

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter()

		{

			public void windowClosing(WindowEvent e)

			{

				

				dispose();

			}

		});
        setTitle("Edit Project Details");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        panelProject.setBackground(new java.awt.Color(255, 255, 255));
        panelProject.setBorder(javax.swing.BorderFactory.createTitledBorder("Project"));
        panelProject.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N

        lblName.setText("Name*:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblStatus.setText("Status*:");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Completed", "Suspended", "Aborted" }));

        lblTheme.setText("Theme:");

        lblStartDate.setText("Start Date*");

        lblEndDate.setText("End Date:");

        javax.swing.GroupLayout panelProjectLayout = new javax.swing.GroupLayout(panelProject);
        panelProject.setLayout(panelProjectLayout);
        panelProjectLayout.setHorizontalGroup(
            panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProjectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProjectLayout.createSequentialGroup()
                        .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStartDate)
                            .addComponent(lblEndDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(dateStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(panelProjectLayout.createSequentialGroup()
                        .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName)))
                    .addGroup(panelProjectLayout.createSequentialGroup()
                        .addComponent(lblTheme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTheme))))
        );

        panelProjectLayout.setVerticalGroup(
            panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProjectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTheme)
                    .addComponent(txtTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                		.addComponent(lblStartDate)
                		.addComponent(dateStartDate)
                    )
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndDate)
                    .addComponent(dateEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panelLinkMedia.setBorder(javax.swing.BorderFactory.createTitledBorder("Hyperlinks & Media"));

        lblAssociatedHyperlink.setText("Associated Hyperlinks");

        btnAddAssociatedLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_icon.png")));
        btnAddAssociatedLink.setText("Add");
        btnAddAssociatedLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAssociatedLinkActionPerformed(evt);
            }
        });

        btnDeleteAssociatedLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete_icon.png"))); 
        btnDeleteAssociatedLink.setText("Delete");
        btnDeleteAssociatedLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAssociatedLinkActionPerformed(evt);
            }
        });

        tableAssociatedHL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Associated Link"
            }
        ));
        scrollPaneAssociated.setViewportView(tableAssociatedHL);

        javax.swing.GroupLayout paneAssociatedLinkLayout = new javax.swing.GroupLayout(paneAssociatedLink);
        paneAssociatedLink.setLayout(paneAssociatedLinkLayout);
        paneAssociatedLinkLayout.setHorizontalGroup(
            paneAssociatedLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAssociatedLinkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneAssociatedLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneAssociatedLinkLayout.createSequentialGroup()
                        .addComponent(lblAssociatedHyperlink)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneAssociatedLinkLayout.createSequentialGroup()
                        .addComponent(btnDeleteAssociatedLink)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                        .addComponent(btnAddAssociatedLink)))
                .addContainerGap())
            .addGroup(paneAssociatedLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneAssociatedLinkLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPaneAssociated, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        paneAssociatedLinkLayout.setVerticalGroup(
            paneAssociatedLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAssociatedLinkLayout.createSequentialGroup()
                .addComponent(lblAssociatedHyperlink)
                .addGap(96, 96, 96)
                .addGroup(paneAssociatedLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAssociatedLink)
                    .addComponent(btnDeleteAssociatedLink))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(paneAssociatedLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneAssociatedLinkLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(scrollPaneAssociated, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        panelLinkMedia.addTab("Associated", paneAssociatedLink);

        lblDirectHyperLink.setText("Direct Hyperlinks");
        
        btnAddDirectLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_icon.png")));
        btnAddDirectLink.setText("Add ");
        btnAddDirectLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDirectLinkActionPerformed(evt);
            }
        });
        
        btnDeleteDirectLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete_icon.png")));
        btnDeleteDirectLink.setText("Delete");
        btnDeleteDirectLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDirectLinkActionPerformed(evt);
            }
        });

        tableDirectHL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Direct Link"
            }
        ));
        scrollPaneDirect.setViewportView(tableDirectHL);

        javax.swing.GroupLayout paneDirecLinkLayout = new javax.swing.GroupLayout(paneDirecLink);
        paneDirecLink.setLayout(paneDirecLinkLayout);
        paneDirecLinkLayout.setHorizontalGroup(
            paneDirecLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDirecLinkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneDirecLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDirecLinkLayout.createSequentialGroup()
                        .addComponent(lblDirectHyperLink)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(paneDirecLinkLayout.createSequentialGroup()
                        .addComponent(btnDeleteDirectLink)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                        .addComponent(btnAddDirectLink)
                        .addContainerGap())
                    .addComponent(scrollPaneDirect, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)))
        );
        paneDirecLinkLayout.setVerticalGroup(
            paneDirecLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDirecLinkLayout.createSequentialGroup()
                .addComponent(lblDirectHyperLink)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneDirect, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(paneDirecLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDirectLink)
                    .addComponent(btnDeleteDirectLink))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelLinkMedia.addTab("Direct", paneDirecLink);

        lblMedia.setText("Media Files");

        tableMedia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "File Name", "File Path"
            }
        ));
        scrollPaneMedia.setViewportView(tableMedia);

        btnAddMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_icon.png")));
        btnAddMedia.setText("Add");
        btnAddMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMediaActionPerformed(evt);
            }
        });
        
        btnDeleteMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete_icon.png")));
        btnDeleteMedia.setText("Delete");
        btnDeleteMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMediaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneMediaLayout = new javax.swing.GroupLayout(paneMedia);
        paneMedia.setLayout(paneMediaLayout);
        paneMediaLayout.setHorizontalGroup(
            paneMediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMediaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMediaLayout.createSequentialGroup()
                        .addComponent(btnDeleteMedia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddMedia))
                    .addComponent(scrollPaneMedia, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(paneMediaLayout.createSequentialGroup()
                        .addComponent(lblMedia)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneMediaLayout.setVerticalGroup(
            paneMediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMediaLayout.createSequentialGroup()
                .addComponent(lblMedia, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(scrollPaneMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneMediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMedia)
                    .addComponent(btnDeleteMedia))
                .addContainerGap())
        );

        panelLinkMedia.addTab("Media", paneMedia);

        panelTeam.setBorder(javax.swing.BorderFactory.createTitledBorder("Team"));

        lblAdvisor.setText("Advisors");

        btnAddAdvisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_icon.png")));
        btnAddAdvisor.setText("Add ");
        btnAddAdvisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdvisorActionPerformed(evt);
            }
        });

        tableAdvisor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Advisor Name"
            }
        ));
        scrollPaneAdvisor.setViewportView(tableAdvisor);

        btnDeleteAdvisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete_icon.png")));
        btnDeleteAdvisor.setText("Delete");
        btnDeleteAdvisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAdvisorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdvisorLayout = new javax.swing.GroupLayout(panelAdvisor);
        panelAdvisor.setLayout(panelAdvisorLayout);
        panelAdvisorLayout.setHorizontalGroup(
            panelAdvisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdvisorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdvisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAdvisorLayout.createSequentialGroup()
                        .addComponent(lblAdvisor)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPaneAdvisor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelAdvisorLayout.createSequentialGroup()
                        .addComponent(btnDeleteAdvisor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(btnAddAdvisor)))
                .addContainerGap())
        );
        panelAdvisorLayout.setVerticalGroup(
            panelAdvisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdvisorLayout.createSequentialGroup()
                .addComponent(lblAdvisor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneAdvisor, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAdvisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAdvisor)
                    .addComponent(btnDeleteAdvisor))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        panelTeam.addTab("Advisors", panelAdvisor);

        lblStudents.setText("Students");

        btnAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_icon.png")));
        btnAddStudent.setText("Add ");
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });

        tableStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
               
            },
            new String [] {
                "Student Name"
            }
        ));
        scrollPaneStudents.setViewportView(tableStudent);

        btnDeleteStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete_icon.png")));
        btnDeleteStudent.setText("Delete");
        btnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelStudentsLayout = new javax.swing.GroupLayout(panelStudents);
        panelStudents.setLayout(panelStudentsLayout);
        panelStudentsLayout.setHorizontalGroup(
            panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStudentsLayout.createSequentialGroup()
                        .addComponent(lblStudents)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPaneStudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStudentsLayout.createSequentialGroup()
                        .addComponent(btnDeleteStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(btnAddStudent)))
                .addContainerGap())
        );
        panelStudentsLayout.setVerticalGroup(
            panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentsLayout.createSequentialGroup()
                .addComponent(lblStudents)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPaneStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddStudent)
                    .addComponent(btnDeleteStudent))
                .addGap(24, 24, 24))
        );

        panelTeam.addTab("Students", panelStudents);

        lblPartners.setText("Partners");

        btnAddPartner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_icon.png")));
        btnAddPartner.setText("Add ");
        btnAddPartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPartnerActionPerformed(evt);
            }
        });

        tablePartners.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Partner"
            }
        ));
        scrollPanePartners.setViewportView(tablePartners);

        btnDeletePartner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete_icon.png")));
        btnDeletePartner.setText("Delete");
        btnDeletePartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePartnerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPartnersLayout = new javax.swing.GroupLayout(panelPartners);
        panelPartners.setLayout(panelPartnersLayout);
        panelPartnersLayout.setHorizontalGroup(
            panelPartnersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPartnersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPartnersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPartnersLayout.createSequentialGroup()
                        .addComponent(lblPartners)
                        .addGap(0, 225, Short.MAX_VALUE))
                    .addComponent(scrollPanePartners, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPartnersLayout.createSequentialGroup()
                        .addComponent(btnDeletePartner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddPartner)))
                .addContainerGap())
        );
        panelPartnersLayout.setVerticalGroup(
            panelPartnersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPartnersLayout.createSequentialGroup()
                .addComponent(lblPartners)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanePartners, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPartnersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPartner)
                    .addComponent(btnDeletePartner))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        panelTeam.addTab("Partners", panelPartners);

        panelScopeLocation.setBorder(javax.swing.BorderFactory.createTitledBorder("Scope of Work & Location of Prototype"));

        javax.swing.GroupLayout paneScopeLayout = new javax.swing.GroupLayout(paneScope);
        paneScope.setLayout(paneScopeLayout);
        paneScopeLayout.setHorizontalGroup(
            paneScopeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneScopeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtScopeofWork, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneScopeLayout.setVerticalGroup(
            paneScopeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneScopeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtScopeofWork, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelScopeLocation.addTab("Scope of Work", paneScope);

        txtLocationPrototype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocationPrototypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneLocationLayout = new javax.swing.GroupLayout(paneLocation);
        paneLocation.setLayout(paneLocationLayout);
        paneLocationLayout.setHorizontalGroup(
            paneLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLocationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLocationPrototype, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneLocationLayout.setVerticalGroup(
            paneLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLocationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLocationPrototype, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelScopeLocation.addTab("Location of Prototype", paneLocation);
        
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save_icon.png")));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close_icon.png")));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)

                		.addComponent(panelLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(panelProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTeam))
                    .addComponent(panelLinkMedia)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave))
                    .addComponent(panelScopeLocation))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                         
                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                
                
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelScopeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelLinkMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addGap(30, 30, 30))
        );

        mainScroll.setViewportView(mainPanel);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(mainScroll,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				mainScroll, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    	if (txtName.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Project should have a name", "Can't edit project", JOptionPane.ERROR_MESSAGE);
		}
		else if (dateStartDate.getDate().after(dateEndDate.getDate())){
			JOptionPane.showMessageDialog(null,"Start Date should be before End Date", "Can't edit project", JOptionPane.ERROR_MESSAGE);
		}
		else{
			DateFormat df = new SimpleDateFormat("MMMM dd, yyyy");

			// String id = txtProjectId.getText();
			String name = txtName.getText();
			String status = (String) comboStatus.getSelectedItem();
			String theme = txtTheme.getText();
			String scope = txtScopeofWork.getText();
			
			String startDate = "";
			if (dateStartDate.getDate() != null)
				startDate = df.format(dateStartDate.getDate());

			String endDate = "";
			if (dateEndDate.getDate() != null)
				endDate = df.format(dateEndDate.getDate());
			
			String location = txtLocationPrototype.getText();
			projectTableController.updateRow(projectId, name, status,
					theme, scope, startDate, endDate, location);
			studentTableController.addStudent(projectId,listStudentId,listStudentName);
			facultyTableController.addFaculty(projectId,listAdvisorId,listAdvisorName);
			partnerTableController.addPartner(projectId,listPartnerName);
			mediaTableController.addMedia(projectId,listMediaName,listMediaPath);

			JOptionPane.showMessageDialog(null,"Project is saved");
		}
	

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    	dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnAddAdvisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdvisorActionPerformed
    	String advisorId = JOptionPane.showInputDialog("Enter Advisor Id");
        System.out.println(advisorId);
        if(advisorId != null && advisorId != ""){
        	advisorModel = new FacultyListModel();
        	 //check if the student id is present in the data base or not
            //if present append the name and student id
        	Faculty advisor = advisorModel.getValidAdvisor(advisorId.toLowerCase());
        	//System.out.println(advisor.getFacultyId());
        	if(advisor != null){
        		listAdvisorId.add(advisor.getFacultyId());
        		listAdvisorName.add(advisor.getName());
        		//DefaultTableModel model = (DefaultTableModel) tableAdvisor.getModel();
        		advisorTableModel.addRow(new Object[]{advisor.getName()});
        	}else{
        		JOptionPane.showMessageDialog(this, "Not a valid advisor");
        	}
        }
    }//GEN-LAST:event_btnAddAdvisorActionPerformed

    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentActionPerformed
    	String studentId = JOptionPane.showInputDialog("Enter Student Id");
        System.out.println(studentId);
        if(studentId != null && studentId != ""){
        	studentModel = new StudentListModel();
        	 //check if the student id is present in the data base or not
            //if present append the name and student id
        	Student student = studentModel.getValidStudent(studentId.toLowerCase());
        	if(student != null){
        		
        		listStudentId.add(student.getStudentId());
        		listStudentName.add(student.getName());
        		
        		studentTableModel.addRow(new Object[]{student.getName()});
        		
        	}else{
        		JOptionPane.showMessageDialog(this, "Not a valid student");
        	}
        }
    }//GEN-LAST:event_btnAddStudentActionPerformed

    private void btnAddPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPartnerActionPerformed
    	 String partnerName = JOptionPane.showInputDialog("Enter Partner Name");
         System.out.println(partnerName);
         if(partnerName != null){
         	listPartnerName.add(partnerName);
         	//DefaultTableModel model = (DefaultTableModel) tablePartners.getModel();
         	partnerTableModel.addRow(new Object[]{partnerName});
            
         }
    }//GEN-LAST:event_btnAddPartnerActionPerformed

    private void txtLocationPrototypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocationPrototypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocationPrototypeActionPerformed

    private void btnAddAssociatedLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAssociatedLinkActionPerformed
    	if (btnSaveCounter == 0){
			JOptionPane.showMessageDialog(null,
					"Please save the project first",
					"Can't add hyperlink",
					JOptionPane.INFORMATION_MESSAGE);
		}else {

			String path = JOptionPane
					.showInputDialog("Enter the path to new associated hyperlink:");

			if (path != null) {
				try {
					associatedTableController.addRow(path, projectId,
							"direct");
				} catch (javax.persistence.RollbackException exp) {
					JOptionPane
							.showMessageDialog(
									null,
									"This hyperlink already exists in the system",
									"Can't add hyperlink",
									JOptionPane.ERROR_MESSAGE);
				}
			}
		}
    }//GEN-LAST:event_btnAddAssociatedLinkActionPerformed

    private void btnAddDirectLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDirectLinkActionPerformed
    	if (btnSaveCounter == 0)
			JOptionPane.showMessageDialog(null,
					"Please save the project first",
					"Can't add hyperlink",
					JOptionPane.INFORMATION_MESSAGE);
		else {

			String path = JOptionPane
					.showInputDialog("Enter the path to new direct hyperlink:");

			if (path != null)
				try {
					directTableController.addRow(path, projectId,
							"direct");
				} catch (javax.persistence.RollbackException exp) {
					JOptionPane
							.showMessageDialog(
									null,
									"This hyperlink already exists in the system",
									"Can't add hyperlink",
									JOptionPane.ERROR_MESSAGE);
				}
		}
    }//GEN-LAST:event_btnAddDirectLinkActionPerformed

    private void btnDeletePartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePartnerActionPerformed
    	//DefaultTableModel m = (DefaultTableModel) tablePartners.getModel();
    	int selectedRow = tablePartners.getSelectedRow();
    	System.out.println("Selected Row:"+selectedRow);
    	if(selectedRow != -1) {
    		partnerTableModel.removeRow(selectedRow);
    		listPartnerName.remove(selectedRow);
    	}
    }//GEN-LAST:event_btnDeletePartnerActionPerformed

    private void btnDeleteAdvisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAdvisorActionPerformed
    	int selectedRow = tableAdvisor.getSelectedRow();
    	if(selectedRow != -1) {
    		advisorTableModel.removeRow(selectedRow);
    		//listAdvisorId.remove(selectedRow);
    		//listAdvisorName.remove(selectedRow);
    	}
    }//GEN-LAST:event_btnDeleteAdvisorActionPerformed

    private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentActionPerformed
        // TODO add your handling code here:
    	int selectedRow = tableStudent.getSelectedRow();
    	if(selectedRow != -1) {
    		studentTableModel.removeRow(selectedRow);
    		//listStudentId.remove(selectedRow);
    		//listStudentName.remove(selectedRow);
    	}
    }//GEN-LAST:event_btnDeleteStudentActionPerformed
    private void btnDeleteMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMediaActionPerformed
    	int selectedRow = tableMedia.getSelectedRow();
    	if(selectedRow != -1) {
    		mediaTableModel.removeRow(selectedRow);
    		//listMediaName.remove(selectedRow);
    		//listMediaPath.remove(selectedRow);
    	}
    }//GEN-LAST:event_btnDeleteMediaActionPerformed
    private void btnDeleteAssociatedLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAssociatedLinkActionPerformed
    	int i = tableAssociatedHL.getSelectedRow();
		if (i >= 0) {

			Object id = tableAssociatedHL.getModel().getValueAt(i, 0);

			associatedTableController.deleteRow((String) id);

		}
    }//GEN-LAST:event_btnDeleteAssociatedLinkActionPerformed

    private void btnDeleteDirectLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDirectLinkActionPerformed
    	int i = tableDirectHL.getSelectedRow();
		if (i >= 0) {

			Object id = tableDirectHL.getModel().getValueAt(i, 0);

			directTableController.deleteRow((String) id);

		}
    }//GEN-LAST:event_btnDeleteDirectLinkActionPerformed

    

    private void btnAddMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMediaActionPerformed
    	JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        file = fc.getSelectedFile();
        listMediaName.add(file.getName());
        listMediaPath.add(file.getAbsolutePath());
       // DefaultTableModel model = (DefaultTableModel) tableMedia.getModel();
		mediaTableModel.addRow(new Object[]{file.getName(),file.getAbsolutePath()});
    }//GEN-LAST:event_btnAddMediaActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectDetailsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectDetailsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectDetailsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectDetailsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectDetailsEdit().setVisible(true);
            }
        });
    }
    
   /* public void initComboBox(){
        String[] status = { "Active", "Completed", "Suspended", "Aborted"};


        jComboBox1.addItem(jComboBox1);
        jComboBox1.setSelectedIndex(4);
        //jComboBox1.addActionListener(this);
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAdvisor;
    private javax.swing.JButton btnAddAssociatedLink;
    private javax.swing.JButton btnAddDirectLink;
    private javax.swing.JButton btnAddMedia;
    private javax.swing.JButton btnAddPartner;
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteAdvisor;
    private javax.swing.JButton btnDeleteAssociatedLink;
    private javax.swing.JButton btnDeleteDirectLink;
    private javax.swing.JButton btnDeleteMedia;
    private javax.swing.JButton btnDeletePartner;
    private javax.swing.JButton btnDeleteStudent;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboStatus;
    private com.toedter.calendar.JDateChooser dateEndDate;
    private com.toedter.calendar.JDateChooser dateStartDate;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane scrollPaneStudents;
    private javax.swing.JScrollPane scrollPanePartners;
    private javax.swing.JScrollPane scrollPaneMedia;
    private javax.swing.JLabel lblAdvisor;
    private javax.swing.JLabel lblAssociatedHyperlink;
    private javax.swing.JLabel lblDirectHyperLink;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblMedia;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPartners;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStudents;
    private javax.swing.JLabel lblTheme;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel paneAssociatedLink;
    private javax.swing.JPanel paneDirecLink;
    private javax.swing.JPanel paneLocation;
    private javax.swing.JPanel paneMedia;
    private javax.swing.JPanel paneScope;
    private javax.swing.JPanel panelAdvisor;
    private javax.swing.JTabbedPane panelLinkMedia;
    private javax.swing.JPanel panelPartners;
    private javax.swing.JPanel panelProject;
    private javax.swing.JTabbedPane panelScopeLocation;
    private javax.swing.JPanel panelStudents;
    private javax.swing.JTabbedPane panelTeam;
    private javax.swing.JScrollPane scrollPaneAdvisor;
    private javax.swing.JScrollPane scrollPaneAssociated;
    private javax.swing.JScrollPane scrollPaneDirect;
    private javax.swing.JTable tableAdvisor;
    private javax.swing.JTable tableAssociatedHL;
    private javax.swing.JTable tableDirectHL;
    private javax.swing.JTable tableMedia;
    private javax.swing.JTable tablePartners;
    private javax.swing.JTable tableStudent;
    private javax.swing.JTextField txtLocationPrototype;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtScopeofWork;
    private javax.swing.JTextField txtTheme;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JScrollPane mainScroll;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
       System.out.println("sda");
      this.getFocusOwner().getName();  
       if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    System.out.println("woot!");
           }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setProjectNameTextField(String valueAt) {
		txtName.setText(valueAt);

	}

	public void setProjectStatusTextField(String valueAt) {
		comboStatus.setSelectedItem(valueAt);

	}

	public void setProjectThemeTextField(String valueAt) {
		txtTheme.setText(valueAt);

	}

	public void setProjectScopeTextField(String valueAt) {
		txtScopeofWork.setText(valueAt);

	}
	

	public void setProjectStartDateTextField(String valueAt) {
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");

		Date date = null;
		try {

			date = formatter.parse(valueAt);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		dateStartDate.setDate(date);

	}

	public void setProjectEndDateTextField(String valueAt) {
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");

		Date date = null;
		try {

			date = formatter.parse(valueAt);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		dateEndDate.setDate(date);

	}
	public void setProjectLocationTextField(String valueAt) {
		txtLocationPrototype.setText(valueAt);

	}
}
