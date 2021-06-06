import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JTextPane;
import java.io.*;
import java.util.*;
import java.lang.*;
class Home extends JFrame implements ActionListener
{
    List<String> list=new ArrayList<String>();
    List<String> reqFiles=new ArrayList<String>();
	public  void RecursivePrint(File[] arr, int level)
	{
		// for-each loop for main directory files
		for (File f : arr)
		{
			// tabs for internal levels
			for (int i = 0; i < level; i++)
				System.out.print("\t");
			
			if(f.isFile())
			    list.add(f.getAbsolutePath());
			
			else if(f.isDirectory())
			{
			    //System.out.println("[" + f.getName() + "]");
			
				// recursion for sub-directories
        			RecursivePrint(f.listFiles(), level + 1);
			}
		}
	}
    String search_file(String path_)
    {
    String smp="";
	String[]      db_tags={"host","host=","port","port=","username","username=","user","user=","password=","connection","con=","con.","connect","pymysql","database","database=","servername","servername=","db","db=","mysqli","query","select","where","mysql","localhost","root","dbcon","uname","upass","admin","update","getconnection"};
	//System.out.println("\nFile name= "+path_+"\n");
	smp=smp+"\n**File name= "+path_+"\n";
    int l=0;
	try{
	File f=new File(path_);
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			StringBuffer sb=new StringBuffer();
			String line;
			while((line=br.readLine())!=null)
			    {
				line=line.toLowerCase();
				if ( line.strip().length()>0 && line.strip().charAt(0)!='/' && line.strip().charAt(0)!='<' && line.strip().charAt(0)!='#' && line.strip().charAt(0)!=')' && line.strip().charAt(0)!='*' && line.strip().charAt(0)!='!' && line.strip().charAt(0)!='|' && line.strip().charAt(0)!='-' && line.strip().length()<128 && !line.contains("import") && !line.contains("run") && !line.contains("if") && !line.contains("include") && !line.contains("jquery") )
				    {
					for(String tags_s : db_tags)
					    {
						if(tags_s.equals("select") && !tags_s.contains("from"))
						    continue;
						if(tags_s.equals("update") && !tags_s.contains("set"))
						    continue;
						if(line.contains(tags_s)){
                            smp=smp+l+" "+line.strip()+"\n";
						    //System.out.println(l+" "+line.strip());
						    continue;
						}
					    }
					
				    }
				sb.append(line);
				sb.append("\n");
				l++;
			    }
			fr.close();}
	catch(IOException e)
	    {
		System.out.println(e);
	    }
    return smp;
    }
    JButton SUBMIT;
    JPanel panel;
    JLabel label1,label2;
    private JCheckBox c;
    private JCheckBox cpp;
    private JCheckBox java;
    private JCheckBox python;
    private JCheckBox php;
    private JCheckBox sql;
    private JCheckBox html;
    private JCheckBox dat;
    private JCheckBox db;
    private JCheckBox log;
    private JCheckBox xml;
    private JCheckBox bin;
    private JCheckBox bat;
    private JCheckBox pl;
    private JCheckBox exe;
    private JCheckBox cs;
    private JCheckBox sh;
    private JCheckBox swift;
    private JCheckBox vb;
    final JTextField text1;
    Home()
    {
	label1=new JLabel();
	label1.setText("                                                           Find  Git DB Commands ");
	label2=new JLabel();
	label2.setText("Folder Path: ");
	text1=new JTextField(100);
	c=new JCheckBox("C");
	c.setSelected(true);
	cpp=new JCheckBox("CPP");
	cpp.setSelected(true);
	java=new JCheckBox("JAVA");
	java.setSelected(true);
        python=new JCheckBox("PYTHON");
	python.setSelected(true);
	php=new JCheckBox("PHP");
	php.setSelected(true);
	sql=new JCheckBox("SQL");
	sql.setSelected(true);
	html = new JCheckBox("HTLM");
	html.setSelected(true);
	dat = new JCheckBox("DATA");
	dat.setSelected(true);
	db = new JCheckBox("DB");
	db.setSelected(true);
	log = new JCheckBox("LOG");
	log.setSelected(true);
	xml = new JCheckBox("XML");
	xml.setSelected(true);
	bin = new JCheckBox("BIN");
	bin.setSelected(true);
	bat = new JCheckBox("BATCH");
	bat.setSelected(true);
	pl = new JCheckBox("PERL");
	pl.setSelected(true);
	exe = new JCheckBox("EXE");
	exe.setSelected(true);
	cs = new JCheckBox("visual c#");
	cs.setSelected(true);
	sh = new JCheckBox("SHELL");
	sh.setSelected(true);
	swift = new JCheckBox("SWIFT");
	swift.setSelected(true);
	vb = new JCheckBox("VisualBasic");
	vb.setSelected(true);

	
	SUBMIT=new JButton("Fetch Data");
	panel = new JPanel(new GridLayout(23,1));
	panel.add(label1);
	panel.add(label2);
	panel.add(text1);
	panel.add(c);
	panel.add(cpp);
	panel.add(java);
	panel.add(python);
	panel.add(php);
	panel.add(sql);
	panel.add(html);
	panel.add(dat);
	panel.add(db);
	panel.add(log);
	panel.add(xml);
	panel.add(bin);
	panel.add(bat);
	panel.add(pl);
	panel.add(exe);
	panel.add(cs);
	panel.add(sh);
	panel.add(swift);
	panel.add(vb);
	
	panel.add(SUBMIT);
	add(panel,BorderLayout.CENTER);
	SUBMIT.addActionListener(this);
	setTitle("Home Page");
    }
    public void actionPerformed(ActionEvent ae)
    {
    List<String> ext=new ArrayList<String>();
    String o="";
	String url=text1.getText();
	Boolean ccheck=c.isSelected();
	if(ccheck)
	    ext.add("c");
	Boolean cppcheck=cpp.isSelected();
	if(cppcheck)
	    ext.add("cpp");
	Boolean javacheck=java.isSelected();
	if(javacheck)
	    ext.add("java");
	Boolean pythoncheck=python.isSelected();
	if(pythoncheck)
	    ext.add("py");
	Boolean phpcheck=php.isSelected();
	if(phpcheck)
	    ext.add("php");
	Boolean sqlcheck=sql.isSelected();
	if(sqlcheck)
	    ext.add("sql");
	Boolean htmlcheck=html.isSelected();
	if(htmlcheck)
	    ext.add("html");
	Boolean datcheck=dat.isSelected();
	if(datcheck)
	    ext.add("dat");
	Boolean dbcheck=db.isSelected();
	if(dbcheck)
	    ext.add("db");
	Boolean logcheck=log.isSelected();
	if(logcheck)
	    ext.add("log");
	Boolean xmlcheck=xml.isSelected();
	if(xmlcheck)
	    ext.add("xml");
	Boolean bincheck=bin.isSelected();
	if(bincheck)
	    ext.add("bin");
	Boolean batcheck=bat.isSelected();
	if(batcheck)
	    ext.add("bat");
	Boolean plcheck=pl.isSelected();
	if(plcheck)
	    ext.add("pl");
	Boolean execheck=exe.isSelected();
	if(execheck)
	    ext.add("exe");
	Boolean cscheck=cs.isSelected();
	if(cscheck)
	    ext.add("cs");
	Boolean shcheck=sh.isSelected();
	if(shcheck)
	    ext.add("sh");
	Boolean swiftcheck=swift.isSelected();
	if(swiftcheck)
	    ext.add("swift");
	Boolean vbcheck=vb.isSelected();
	if(vbcheck)
	    ext.add("vb");
	if (!url.equals("")){
	NextPage page=new NextPage();
	page.setVisible(true);
	File folder =new File(url);
	String[] files=folder.list();
	File arr[]=folder.listFiles();
	RecursivePrint(arr,0);
    for ( String pth : list)
			    {
				for(String e:ext)
				    {
					if(pth.endsWith(e))
					    {
						o=o+search_file(pth);
						
					    }
				    }
			    }
	JTextArea pane;
	//pane.setText("URL="+url+"\n c="+ccheck+"\n cpp="+cppcheck+"\n java="+javacheck+"first file="+o);
	pane=new JTextArea("URL="+url+"\n"+o);
	pane.setLineWrap(true);
	pane.setWrapStyleWord(true);
	JScrollPane paneScrolPane=new JScrollPane(pane);
	paneScrolPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	paneScrolPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	
	page.getContentPane().add(paneScrolPane);
    }
	else{
	    System.out.println("Enter a valid URL: ");
	    JOptionPane.showMessageDialog(this,"Invalid URL","Error",JOptionPane.ERROR_MESSAGE);
	}
}
    public static void main(String[] args)
    {
	EventQueue.invokeLater(()->{
		JFrame frame=new Home();
		frame.setTitle("Home");
		frame.setSize(2000,1300);
		frame.setVisible(true);
	    });
    }
}
