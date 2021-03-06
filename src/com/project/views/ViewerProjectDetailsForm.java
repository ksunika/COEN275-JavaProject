package com.project.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTable;

import com.project.controller.FacultyTableController;
import com.project.controller.HyperlinkTableController;
import com.project.controller.MediaTableController;
import com.project.controller.PartnerTableController;
import com.project.controller.StudentTableController;
import com.project.controller.ViewerProjectTableController;

/**
 * 
 * @author ksusha
 */

// require index of the project (not project_id, but row number starting from 0)
public class ViewerProjectDetailsForm extends javax.swing.JFrame {

	private JTable jtablePartner;
	private JTable jtableAdvisor;
	private JTable jtableStudent;

	private JTable jtableAssociatedHl;
	private JTable jtableDirectHl;
	private JTable jtableMedia;

	private ViewerProjectTableController projectTableController;
	private PartnerTableController partnerTableController;
	private FacultyTableController facultyTableController;
	private StudentTableController studentTableController;

	private HyperlinkTableController associatedTableController;
	private HyperlinkTableController directTableController;
	private MediaTableController mediaTableController;

	/**
	 * Creates new form ProjectDetailsForm
	 */
	public ViewerProjectDetailsForm(String projectId) {

		initComponents();

		projectTableController = new ViewerProjectTableController(this,
				projectId);
		partnerTableController = new PartnerTableController(this, projectId);
		facultyTableController = new FacultyTableController(this, projectId);
		studentTableController = new StudentTableController(this, projectId);

		// associatedTableController = new AssociatedHLTableController(this,
		// projectId);
		directTableController = new HyperlinkTableController(this, projectId,
				"direct");
		associatedTableController = new HyperlinkTableController(this,
				projectId, "associated");
		mediaTableController = new MediaTableController(this, projectId);

		addJTables();

	}

	public void addJTables() {
		// add the data and column names to a JTable

		jtablePartner = new JTable(partnerTableController.getTableModel());
		jtablePartner.removeColumn(jtablePartner.getColumn("project_id"));
		jtablePartner.getColumn("partnerName").setHeaderValue("Name");
		scrollPanePartner.setViewportView(jtablePartner);

		jtableAdvisor = new JTable(facultyTableController.getTableModel());
		jtableAdvisor.removeColumn(jtableAdvisor.getColumn("faculty_id"));
		jtableAdvisor.removeColumn(jtableAdvisor.getColumn("project_id"));
		jtableAdvisor.getColumn("name").setHeaderValue("Name");
		scrollPaneAdvisor.setViewportView(jtableAdvisor);

		jtableStudent = new JTable(studentTableController.getTableModel());
		jtableStudent.getColumn("name").setHeaderValue("Name");
		jtableStudent.getColumn("student_id").setHeaderValue("ID");
		scrollPaneStudent.setViewportView(jtableStudent);

		jtableAssociatedHl = new JTable(
				associatedTableController.getTableModel());
		jtableAssociatedHl.removeColumn(jtableAssociatedHl
				.getColumn("project_id"));
		jtableAssociatedHl.removeColumn(jtableAssociatedHl.getColumn("id"));
		jtableAssociatedHl.getColumn("hyperlink").setHeaderValue("Path");
		scrollPaneAssociated.setViewportView(jtableAssociatedHl);

		jtableDirectHl = new JTable(directTableController.getTableModel());
		jtableDirectHl.removeColumn(jtableDirectHl.getColumn("project_id"));
		jtableDirectHl.removeColumn(jtableDirectHl.getColumn("id"));
		jtableDirectHl.getColumn("hyperlink").setHeaderValue("Path");
		scrollPaneDirect.setViewportView(jtableDirectHl);

		jtableMedia = new JTable(mediaTableController.getTableModel());
		jtableMedia.removeColumn(jtableMedia.getColumn("project_id"));
		jtableMedia.getColumn("name").setHeaderValue("Name");
		jtableMedia.getColumn("path").setHeaderValue("Path");
		scrollPaneMedia.setViewportView(jtableMedia);
	}

	public ViewerProjectDetailsForm() {
		this("02");// if index is not given, show for the first line
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		mainPanel = new javax.swing.JPanel();
		panelProject = new javax.swing.JPanel();
		lblName = new javax.swing.JLabel();
		lblStatus = new javax.swing.JLabel();
		lblTheme = new javax.swing.JLabel();
		lblStartDate = new javax.swing.JLabel();
		lblEndDate = new javax.swing.JLabel();
		txtName = new javax.swing.JTextField();
		txtStatus = new javax.swing.JTextField();
		txtTheme = new javax.swing.JTextField();
		txtStartDate = new javax.swing.JTextField();
		txtEndDate = new javax.swing.JTextField();
		jTabbedPaneTeam = new javax.swing.JTabbedPane();
		panelAdvisor = new javax.swing.JPanel();
		scrollPaneAdvisor = new javax.swing.JScrollPane();
		panelStudent = new javax.swing.JPanel();
		scrollPaneStudent = new javax.swing.JScrollPane();
		panelPartners = new javax.swing.JPanel();
		scrollPanePartner = new javax.swing.JScrollPane();
		jTabbedPaneTimeline = new javax.swing.JTabbedPane();
		panelScope = new javax.swing.JPanel();
		txtScope = new javax.swing.JTextField();
		panelLocation = new javax.swing.JPanel();
		txtLocation = new javax.swing.JTextField();
		jTabbedPaneMedia = new javax.swing.JTabbedPane();
		panelAssociated = new javax.swing.JPanel();
		scrollPaneAssociated = new javax.swing.JScrollPane();
		panelDirect = new javax.swing.JPanel();
		scrollPaneDirect = new javax.swing.JScrollPane();
		panelMedia = new javax.swing.JPanel();
		scrollPaneMedia = new javax.swing.JScrollPane();
		panelLogo = new javax.swing.JPanel();
		lblLogo = new javax.swing.JLabel();
		btnClose = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()

		{

			public void windowClosing(WindowEvent e)

			{

				dispose();

			}

		});
		setTitle("Project Details");
		setBounds(new java.awt.Rectangle(0, 0, 600, 400));
		setBackground(new java.awt.Color(255, 255, 255));
		setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
		mainPanel.setBackground(new java.awt.Color(255, 255, 255));

		panelProject.setBackground(new java.awt.Color(255, 255, 255));

		mainPanel.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N

		panelProject.setBorder(javax.swing.BorderFactory.createTitledBorder(
				null, "Project",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, getFont()));
		panelProject.setFont(getFont());

		lblName.setFont(getFont());
		lblName.setText("Name:");

		lblStatus.setFont(getFont());
		lblStatus.setText("Status:");

		lblTheme.setFont(getFont());
		lblTheme.setText("Theme:");

		lblStartDate.setFont(getFont());
		lblStartDate.setText("Start Date:");
		lblStartDate.setPreferredSize(new java.awt.Dimension(62, 16));

		lblEndDate.setFont(getFont());
		lblEndDate.setText("End Date:");

		txtName.setEditable(false);
		txtName.setFont(getFont());
		txtName.setText("Name");
		txtName.setFocusable(false);

		txtStatus.setEditable(false);
		txtStatus.setFont(getFont());
		txtStatus.setText("Status");
		txtStatus.setFocusable(false);
		txtStatus.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtStatusActionPerformed(evt);
			}
		});

		txtTheme.setEditable(false);
		txtTheme.setFont(getFont());
		txtTheme.setText("Theme");
		txtTheme.setFocusable(false);

		txtStartDate.setEditable(false);
		txtStartDate.setFont(getFont());
		txtStartDate.setText("Start Date");
		txtStartDate.setFocusable(false);

		txtEndDate.setEditable(false);
		txtEndDate.setFont(getFont());
		txtEndDate.setText("End Date");
		txtEndDate.setFocusable(false);

		javax.swing.GroupLayout panelProjectLayout = new javax.swing.GroupLayout(
				panelProject);
		panelProject.setLayout(panelProjectLayout);
		panelProjectLayout
				.setHorizontalGroup(panelProjectLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelProjectLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												panelProjectLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblName)
														.addComponent(lblStatus)
														.addComponent(lblTheme)
														.addComponent(
																lblStartDate)
														.addComponent(
																lblEndDate))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												53, Short.MAX_VALUE)
										.addGroup(
												panelProjectLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(txtStatus)
														.addComponent(txtName)
														.addComponent(txtTheme)
														.addComponent(
																txtStartDate)
														.addComponent(
																txtEndDate))
										.addContainerGap()));
		panelProjectLayout
				.setVerticalGroup(panelProjectLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelProjectLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												panelProjectLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lblName)
														.addComponent(
																txtName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												panelProjectLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lblStatus)
														.addComponent(
																txtStatus,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												panelProjectLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lblTheme)
														.addComponent(
																txtTheme,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												panelProjectLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblStartDate,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtStartDate,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												panelProjectLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblEndDate,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtEndDate,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jTabbedPaneTeam.setBorder(javax.swing.BorderFactory.createTitledBorder(
				null, "Team",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, getFont()));
		jTabbedPaneTeam.setFont(getFont());

		panelAdvisor.setFont(getFont());

		scrollPaneAdvisor.setFont(getFont());

		javax.swing.GroupLayout panelAdvisorLayout = new javax.swing.GroupLayout(
				panelAdvisor);
		panelAdvisor.setLayout(panelAdvisorLayout);
		panelAdvisorLayout
				.setHorizontalGroup(panelAdvisorLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelAdvisorLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPaneAdvisor,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												299, Short.MAX_VALUE)
										.addContainerGap()));
		panelAdvisorLayout
				.setVerticalGroup(panelAdvisorLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								panelAdvisorLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPaneAdvisor,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												162, Short.MAX_VALUE)
										.addContainerGap()));

		jTabbedPaneTeam.addTab("Advisors", panelAdvisor);

		panelStudent.setFont(getFont());

		scrollPaneStudent.setFont(getFont());

		javax.swing.GroupLayout panelStudentLayout = new javax.swing.GroupLayout(
				panelStudent);
		panelStudent.setLayout(panelStudentLayout);
		panelStudentLayout
				.setHorizontalGroup(panelStudentLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelStudentLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPaneStudent,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												299, Short.MAX_VALUE)
										.addContainerGap()));
		panelStudentLayout
				.setVerticalGroup(panelStudentLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								panelStudentLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPaneStudent,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												162, Short.MAX_VALUE)
										.addContainerGap()));

		jTabbedPaneTeam.addTab("Students", panelStudent);

		panelPartners.setFont(getFont());

		scrollPanePartner.setFont(getFont());

		javax.swing.GroupLayout panelPartnersLayout = new javax.swing.GroupLayout(
				panelPartners);
		panelPartners.setLayout(panelPartnersLayout);
		panelPartnersLayout
				.setHorizontalGroup(panelPartnersLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelPartnersLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPanePartner,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												299, Short.MAX_VALUE)
										.addContainerGap()));
		panelPartnersLayout
				.setVerticalGroup(panelPartnersLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelPartnersLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPanePartner,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												162, Short.MAX_VALUE)
										.addContainerGap()));

		jTabbedPaneTeam.addTab("Partners", panelPartners);

		jTabbedPaneTimeline.setBorder(javax.swing.BorderFactory
				.createTitledBorder(null, "Scope & Location",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						getFont()));
		jTabbedPaneTimeline.setFont(getFont());

		txtScope.setFont(getFont());
		txtScope.setText("Scope");

		javax.swing.GroupLayout panelScopeLayout = new javax.swing.GroupLayout(
				panelScope);
		panelScope.setLayout(panelScopeLayout);
		panelScopeLayout
				.setHorizontalGroup(panelScopeLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelScopeLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												txtScope,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												603, Short.MAX_VALUE)
										.addContainerGap()));
		panelScopeLayout.setVerticalGroup(panelScopeLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panelScopeLayout
						.createSequentialGroup()
						.addComponent(txtScope,
								javax.swing.GroupLayout.DEFAULT_SIZE, 59,
								Short.MAX_VALUE).addContainerGap()));

		jTabbedPaneTimeline.addTab("Scope of Work", panelScope);

		txtLocation.setFont(getFont());
		txtLocation.setText("Location");

		javax.swing.GroupLayout panelLocationLayout = new javax.swing.GroupLayout(
				panelLocation);
		panelLocation.setLayout(panelLocationLayout);
		panelLocationLayout
				.setHorizontalGroup(panelLocationLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelLocationLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												txtLocation,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												603, Short.MAX_VALUE)
										.addContainerGap()));
		panelLocationLayout
				.setVerticalGroup(panelLocationLayout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						panelLocationLayout
								.createSequentialGroup()
								.addComponent(txtLocation,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										59, Short.MAX_VALUE).addContainerGap()));

		jTabbedPaneTimeline.addTab("Location of Prototype", panelLocation);

		jTabbedPaneMedia.setBorder(javax.swing.BorderFactory
				.createTitledBorder(null, "Hyperlinks & Media",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						getFont()));
		jTabbedPaneMedia.setFont(getFont());

		panelAssociated.setFont(getFont());

		scrollPaneAssociated.setFont(getFont());

		javax.swing.GroupLayout panelAssociatedLayout = new javax.swing.GroupLayout(
				panelAssociated);
		panelAssociated.setLayout(panelAssociatedLayout);
		panelAssociatedLayout
				.setHorizontalGroup(panelAssociatedLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelAssociatedLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPaneAssociated,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												603, Short.MAX_VALUE)
										.addContainerGap()));
		panelAssociatedLayout.setVerticalGroup(panelAssociatedLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						panelAssociatedLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPaneAssociated,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										64,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		jTabbedPaneMedia.addTab("Associated", panelAssociated);

		panelDirect.setFont(getFont());

		scrollPaneDirect.setFont(getFont());

		javax.swing.GroupLayout panelDirectLayout = new javax.swing.GroupLayout(
				panelDirect);
		panelDirect.setLayout(panelDirectLayout);
		panelDirectLayout
				.setHorizontalGroup(panelDirectLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelDirectLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPaneDirect,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												603, Short.MAX_VALUE)
										.addContainerGap()));
		panelDirectLayout.setVerticalGroup(panelDirectLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						panelDirectLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPaneDirect,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										64,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		jTabbedPaneMedia.addTab("Direct", panelDirect);

		panelMedia.setFont(getFont());

		scrollPaneMedia.setFont(getFont());

		javax.swing.GroupLayout panelMediaLayout = new javax.swing.GroupLayout(
				panelMedia);
		panelMedia.setLayout(panelMediaLayout);
		panelMediaLayout
				.setHorizontalGroup(panelMediaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelMediaLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												scrollPaneMedia,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												603, Short.MAX_VALUE)
										.addContainerGap()));
		panelMediaLayout.setVerticalGroup(panelMediaLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panelMediaLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneMedia,
								javax.swing.GroupLayout.PREFERRED_SIZE, 64,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jTabbedPaneMedia.addTab("Media", panelMedia);

		panelLogo.setBackground(new java.awt.Color(255, 255, 255));

		lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/image/Frugal_Blk_BriteRed_72dpi.jpg"))); // NOI18N

		javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(
				panelLogo);
		panelLogo.setLayout(panelLogoLayout);
		panelLogoLayout.setHorizontalGroup(panelLogoLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panelLogoLayout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE).addComponent(lblLogo)
						.addGap(0, 0, Short.MAX_VALUE)));
		panelLogoLayout.setVerticalGroup(panelLogoLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panelLogoLayout.createSequentialGroup()
						.addGap(0, 12, Short.MAX_VALUE).addComponent(lblLogo)
						.addGap(0, 12, Short.MAX_VALUE)));

		btnClose.setText("Close");

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
				mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)

														.addComponent(
																panelLogo,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jTabbedPaneMedia)
														.addGroup(
																mainPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				panelProject,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTabbedPaneTeam,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				344,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addComponent(
																jTabbedPaneTimeline)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																mainPanelLayout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnClose)))
										.addContainerGap()));
		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												panelLogo,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jTabbedPaneTeam)
														.addComponent(
																panelProject,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTabbedPaneTimeline,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												137,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTabbedPaneMedia,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												154,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnClose)
										.addContainerGap()));

		jTabbedPaneMedia.getAccessibleContext().setAccessibleName(
				"associatedPanel");
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(mainPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtStatusActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtStatusActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(
					ViewerProjectDetailsForm.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(
					ViewerProjectDetailsForm.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(
					ViewerProjectDetailsForm.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(
					ViewerProjectDetailsForm.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ViewerProjectDetailsForm().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTabbedPane jTabbedPaneMedia;
	private javax.swing.JTabbedPane jTabbedPaneTeam;
	private javax.swing.JTabbedPane jTabbedPaneTimeline;
	private javax.swing.JLabel lblEndDate;
	private javax.swing.JLabel lblLogo;
	private javax.swing.JLabel lblName;
	private javax.swing.JLabel lblStartDate;
	private javax.swing.JLabel lblStatus;
	private javax.swing.JLabel lblTheme;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel panelAdvisor;
	private javax.swing.JPanel panelAssociated;
	private javax.swing.JPanel panelDirect;
	private javax.swing.JPanel panelLocation;
	private javax.swing.JPanel panelLogo;
	private javax.swing.JPanel panelMedia;
	private javax.swing.JPanel panelPartners;
	private javax.swing.JPanel panelProject;
	private javax.swing.JPanel panelScope;
	private javax.swing.JPanel panelStudent;
	private javax.swing.JScrollPane scrollPaneAdvisor;
	private javax.swing.JScrollPane scrollPaneAssociated;
	private javax.swing.JScrollPane scrollPaneDirect;
	private javax.swing.JScrollPane scrollPaneMedia;
	private javax.swing.JScrollPane scrollPanePartner;
	private javax.swing.JScrollPane scrollPaneStudent;
	private javax.swing.JTextField txtEndDate;
	private javax.swing.JTextField txtLocation;
	private javax.swing.JTextField txtName;
	private javax.swing.JTextField txtScope;
	private javax.swing.JTextField txtStartDate;
	private javax.swing.JTextField txtStatus;
	private javax.swing.JTextField txtTheme;
	private javax.swing.JButton btnClose;

	// End of variables declaration//GEN-END:variables
	public void setProjectNameTextField(String valueAt) {
		txtName.setText(valueAt);

	}

	public void setProjectStatusTextField(String valueAt) {
		txtStatus.setText(valueAt);

	}

	public void setProjectThemeTextField(String valueAt) {
		txtTheme.setText(valueAt);

	}

	public void setProjectScopeTextField(String valueAt) {
		txtScope.setText(valueAt);

	}

	public void setProjectStartDateTextField(String valueAt) {
		txtStartDate.setText(valueAt);

	}

	public void setProjectEndDateTextField(String valueAt) {
		txtEndDate.setText(valueAt);

	}

	public void setProjectLocationTextField(String valueAt) {
		txtLocation.setText(valueAt);

	}
}
