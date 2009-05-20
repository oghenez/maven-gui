package com.mui.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Level;

import com.mui.BootLoaderException;
import com.mui.ContextLoadException;
import com.mui.MavenCommonContext;
import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;
import com.mui.env.MavenEnvironmentConstants;
import com.mui.env.MavenEnvironmentVariables;
import com.mui.env.UnknownVariableException;
import com.mui.logger.MavenLogger;
import com.mui.logger.MavenProgressMonitor;
import com.mui.logger.TextAreaLogAppender;

public class TestFrame extends JFrame implements MavenEnvironmentConstants,
MavenGuiConstants{

	public static String MAVEN_HOME;
	public static String JAVA_HOME;

	private static MavenGUIContext mavenGUIContext = MavenGUIContext.getInstance();

	private static MavenCommonContext context = MavenCommonContext
			.getInstance();

	public static void boot() throws UnknownVariableException,
			ContextLoadException, BootLoaderException, IOException {
		loadInitialContext();
		context.mavenEnvironmentVariables = loadEnvironmentVariavles();
	}

	private static MavenEnvironmentVariables loadEnvironmentVariavles()
			throws UnknownVariableException, FileNotFoundException, IOException {
		Map<String, String> sysEnvMap = System.getenv();
		MavenEnvironmentVariables initialVars = new MavenEnvironmentVariables();
		Properties properties = new Properties();
		File propFile = new File(PROPERTIES_FILE_NAME);
		if (propFile.exists()) {
			properties.load(new FileInputStream(propFile));
			MAVEN_HOME = properties.getProperty("MAVEN_HOME");
			JAVA_HOME = properties.getProperty("JAVA_HOME");
		}

		if (MAVEN_HOME != null && MAVEN_HOME.trim().length() > 0) {
			initialVars.addEnvironmentVariable(MAVEN_HOME_ENV_VAR_NAME,
					MAVEN_HOME, true);
		} else {
			MAVEN_HOME = sysEnvMap.get(MAVEN_HOME_ENV_VAR_NAME);
			if (MAVEN_HOME != null && MAVEN_HOME.trim().length() > 0) {
				initialVars.addEnvironmentVariable(MAVEN_HOME_ENV_VAR_NAME,
						MAVEN_HOME, true);
			} else {
				MAVEN_HOME = DEFAULT_MAVEN_HOME;
				File home = new File(DEFAULT_MAVEN_HOME);
				File m2Home = new File(home, ".m2");
				if (!m2Home.exists()) {
					m2Home.mkdir();
				}
				File confDir = new File(DEFAULT_CONF_DIR);
				if (!confDir.exists()) {
					confDir.mkdir();
				}
				File libDir = new File(DEFAULT_LIB_DIR);
				if (!libDir.exists()) {
					libDir.mkdir();
				}
			}
		}

		if (JAVA_HOME != null && JAVA_HOME.trim().length() > 0) {
			initialVars.addEnvironmentVariable(JAVA_HOME_ENV_VAR_NAME,
					JAVA_HOME, true);
		} else {
			JAVA_HOME = sysEnvMap.get(JAVA_HOME_ENV_VAR_NAME);
			if (JAVA_HOME != null && JAVA_HOME.trim().length() > 0) {
				initialVars.addEnvironmentVariable(JAVA_HOME_ENV_VAR_NAME,
						JAVA_HOME, true);
			} else {
				throw new UnknownVariableException("JAVA_HOME is not set.");
			}
		}
		System.setProperty(JAVA_HOME_SYS_PROP_NAME, JAVA_HOME);
		System.setProperty(USER_HOME_SYS_PROP_NAME, MAVEN_HOME);
		System.setProperty(MAVEN_HOME_SYS_PROP_NAME, MAVEN_HOME);
		System.out.println(MAVEN_HOME);
		return initialVars;
	}

	private static void loadInitialContext() throws ContextLoadException {
		File contextFile = new File(DEFAULT_CONTEXT_DIR + "/"
				+ CONTEXT_FILE_NAME);
		if (contextFile.exists()) {
			ObjectInputStream objectInputStream = null;
			try {
				objectInputStream = new ObjectInputStream(new FileInputStream(
						contextFile));
				MavenGUIContext ctx = (MavenGUIContext) objectInputStream
						.readObject();
				if (ctx != null) {
					mavenGUIContext.setEnvironmentVariables(ctx
							.getEnvironmentVariables());
					mavenGUIContext.setFrameLocation(ctx.getFrameLocation());
					mavenGUIContext.setFrameSize(ctx.getFrameSize());
					mavenGUIContext.setMavenHomeDir(ctx.getMavenHomeDir());
					mavenGUIContext.setProjectBaseDirPath(ctx
							.getProjectBaseDirPath());
					mavenGUIContext
							.setSettingsFileDir(ctx.getSettingsFileDir());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (objectInputStream != null) {
					try {
						objectInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			File contextDir = new File(DEFAULT_CONTEXT_DIR);
			if (!contextDir.exists()) {
				contextDir.mkdir();
			}
			ObjectOutputStream os = null;
			try {
				contextFile.createNewFile();
				os = new ObjectOutputStream(new FileOutputStream(contextFile));
				os.writeObject(mavenGUIContext);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public TestFrame() {
		try {
			boot();
		} catch (UnknownVariableException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error !!!", JOptionPane.ERROR_MESSAGE);
		} catch (ContextLoadException e) {
			e.printStackTrace();
		} catch (BootLoaderException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		initComponents();
		initLogger();
	}

	private void initLogger() {
		TextAreaLogAppender device = new TextAreaLogAppender(
				this.outputTextArea);
		context.textAreaLogAppender = device;
		context.mavenProgressMonitor = new MavenProgressMonitor(
				downloadProgressBar, downloadLabel);

	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		baseDirTextField = new javax.swing.JTextField(
				"F:\\MAVEN_GUI\\maven-2.0.9-src");
		cmdTextField = new javax.swing.JTextField(
				"install -Dmaven.test.skip=true");
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		outputTextArea = new javax.swing.JTextArea();
		downloadProgressBar = new javax.swing.JProgressBar();
		downloadLabel = new javax.swing.JLabel();
		browseButton = new javax.swing.JButton();
		execuitButton = new javax.swing.JButton();
		clearButton = new javax.swing.JButton();
		wrapButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Maven Test");

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel1.setText("Base Directory");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel2.setText("Command Line args");

		jPanel2.setBorder(javax.swing.BorderFactory
				.createTitledBorder(" Output "));

		outputTextArea.setColumns(20);
		outputTextArea.setEditable(false);
		outputTextArea.setRows(5);
		jScrollPane1.setViewportView(outputTextArea);

		// downloadLabel.setFont(new java.awt.Font("Arial Narrow", 0, 12)); //
		// NOI18N
		downloadLabel.setForeground(new java.awt.Color(0, 0, 255));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																557,
																Short.MAX_VALUE)
														.addComponent(
																downloadLabel,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																557,
																Short.MAX_VALUE)
														.addComponent(
																downloadProgressBar,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																557,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												196, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												downloadLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												20,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												downloadProgressBar,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		browseButton.setText("Browse");
		browseButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				browseButtonActionPerformed(evt);
			}
		});

		execuitButton.setText("Run");
		execuitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				execuitButtonActionPerformed(evt);
			}
		});

		clearButton.setText("Clear");
		clearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearButtonActionPerformed(evt);
			}
		});

		wrapButton.setText("Wrap");
		wrapButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				wrapButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel1))
																		.addGap(
																				26,
																				26,
																				26)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								cmdTextField,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								383,
																								Short.MAX_VALUE)
																						.addComponent(
																								baseDirTextField,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								383,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								browseButton,
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								execuitButton,
																								javax.swing.GroupLayout.Alignment.TRAILING)))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				wrapButton)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				clearButton)))
										.addContainerGap()));

		jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { browseButton, execuitButton });

		jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { jLabel1, jLabel2 });

		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																browseButton)
														.addComponent(
																baseDirTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																execuitButton)
														.addComponent(
																cmdTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																clearButton)
														.addComponent(
																wrapButton))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {
		browseForBaseDir();
	}

	private void execuitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		runCommand();
	}

	private void wrapButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		outputTextArea.setText("");
	}

	private javax.swing.JTextField baseDirTextField;
	private javax.swing.JButton browseButton;
	private javax.swing.JButton clearButton;
	private javax.swing.JTextField cmdTextField;
	private javax.swing.JLabel downloadLabel;
	private javax.swing.JProgressBar downloadProgressBar;
	private javax.swing.JButton execuitButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea outputTextArea;
	private javax.swing.JButton wrapButton;

	private void browseForBaseDir() {
		baseDirTextField.setText("");
		JFileChooser chooser = new JFileChooser(".");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int opt = chooser.showOpenDialog(this);
		if (opt == JFileChooser.APPROVE_OPTION) {
			boolean validBase = false;
			File dir = chooser.getSelectedFile();
			if (dir != null) {
				File[] allFiles = dir.listFiles();
				for (File file : allFiles) {
					if (file.getName().toLowerCase().equals("pom.xml")) {
						validBase = true;
						break;
					}
				}
				if (validBase) {
					baseDirTextField.setText(dir.getAbsolutePath());
				} else {
					JOptionPane.showMessageDialog(this,
							"Invalid base directory");
				}
			}
		}
	}

	private void runCommand() {
		if ((baseDirTextField.getText() != null && !baseDirTextField.getText()
				.equals(""))
				&& (cmdTextField.getText() != null && !cmdTextField.getText()
						.equals(""))) {
			MavenLogger
					.init(new TextAreaLogAppender(outputTextArea), Level.ALL);
			System.setProperty("user.dir", baseDirTextField.getText());
			File f = new File("D:\\TOOLS\\Java\\jdk1.6.0_06\\bin");
			boolean b = f.exists();
			if (!f.exists()) {
				System.out.println("jhkasdjfh ksjdfhkjsfh");
			}
			System.setProperty("java.home", f.getAbsolutePath());
			System.out.println(System.getProperty("java.home"));
			String cmdLine = cmdTextField.getText();
			String[] args = cmdLine.split(" ");
			MavenTestWorker worker = new MavenTestWorker(baseDirTextField
					.getText(), args);
			worker.execute();
		}

	}

}
