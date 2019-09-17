package main;


import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.sql.*;
import model.Student;
import model.Teacher;

/**
 * 02-04-2019
 * This is the Main class where the GUI is created
 * Action listeners are stated here
 * @author dalye
 *
 */
public class Main extends Application {
	private Label students;
	private TextField first;
	private TextField middle;
	private TextField last;
	private TextField email;
	private TextField phone;
	private TextField dob;
	private Button registers;
	private Button removes;
	
	private Label classgroups;
	private TextField classname;
	private Button createc;
	private Button removec;
	
	private Label teachers;
	private TextField tfirst;
	private TextField tmiddle;
	private TextField tlast;
	private TextField degree;
	private Button addt;
	private Button removet;
	
	
	TextArea list = new TextArea();
	
	
	/**
	 *Controller object is instanciated 
	 */
	private static Controller controller = new Controller();

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			BorderPane mainPane = new BorderPane();
			Group root = new Group();
			Scene scene = new Scene(root,750,600);		
			

			//FOR REGISTERING
			
			
			//
			//REGISTER STUDENT SECTION
			//
			students = new Label("----------------------------STUDENT----------------------------");
			
			first = new TextField();
			first.setPromptText("First Name");
			middle = new TextField();
			middle.setPromptText("Middle Name (Optional)");
			last = new TextField();
			last.setPromptText("Last Name");
			email = new TextField();
			email.setPromptText("Email");
			phone = new TextField();
			phone.setPromptText("Phone No.");
			dob = new TextField();
			dob.setPromptText("Date of Birth");
			TextField sclass = new TextField();
			sclass.setPromptText("Class to add Student to");
			registers = new Button("Register");
			
			FlowPane studenttexts = new FlowPane();
			studenttexts.getChildren().addAll(first,middle,last,email,phone,dob, sclass);
			HBox h2 = new HBox();
			h2.getChildren().addAll(registers);
			
			
			VBox vs = new VBox();
			vs.getChildren().addAll(students,studenttexts,h2);
			
			//
			//CLASS GROUP GUI
			//
			classgroups = new Label("----------------------------CLASS GROUPS----------------------------");
			classname = new TextField();
			classname.setPromptText("Name of Class");
			createc = new Button("Add Class");
			removec = new Button("Remove (By Name)");
			
			HBox hc = new HBox();
			hc.getChildren().addAll(createc,removec);
			
			VBox vc = new VBox();
			vc.getChildren().addAll(classgroups,classname,hc);
			
			//
			//	TEACHER GUI
			//
			teachers = new Label("----------------------------TEACHERS----------------------------");
			tfirst = new TextField();
			tfirst.setPromptText("First Name");
			tmiddle = new TextField();
			tmiddle.setPromptText("Middle Name (Optional)");
			tlast = new TextField();
			tlast.setPromptText("Last Name");
			TextField temail = new TextField();
			temail.setPromptText("Email");
			TextField tphone = new TextField();
			tphone.setPromptText("Phone");
			degree = new TextField();
			degree.setPromptText("Degree");
			
			addt = new Button("Add Teacher");
			
			HBox ht = new HBox();
			ht.getChildren().addAll(addt);
			FlowPane teachertexts = new FlowPane();
			teachertexts.getChildren().addAll(tfirst,tmiddle,tlast,temail,tphone,degree);
			
			VBox vt = new VBox();
			vt.getChildren().addAll(teachers,teachertexts,ht);
			
			
			VBox vr = new VBox();
			vr.getChildren().addAll(vc,vt,vs);
			
			//
			//			EXTRA FUNCTIONALITY -- Student
			//
			Label studhead = new Label("-------------STUDENT FUNCTIONALITY------------");
			
			TextField entersid = new TextField();
			entersid.setPromptText("Enter Student ID to edit  ");
			Button bentersid = new Button("Submit");
			removes = new Button("Remove Student");
			HBox studid = new HBox();
			studid.getChildren().addAll(entersid,bentersid,removes);
			
			Label displayst = new Label();
			
			Label modules = new Label("-----------Add and remove modules-----------");
			TextField addmod = new TextField();
			addmod.setPromptText("Module Name");
			TextField modgrade = new TextField();
			modgrade.setPromptText("Module Grade");
			
			HBox modtexts = new HBox();
			modtexts.getChildren().addAll(addmod,modgrade);
			
			Button baddmod = new Button("Add");
			Button modremove = new Button("Remove");
			
			HBox modBs = new HBox();
			modBs.getChildren().addAll(baddmod,modremove);
			
			VBox xstudent = new VBox();
			xstudent.getChildren().addAll(studhead,studid,displayst,modules,modtexts,modBs);
			
			
			Label teahead = new Label("-------------TEACHER FUNCTIONALITY------------");
			TextField entertid = new TextField();
			entertid.setPromptText("Enter a teacher ID to edit   ");
			Button bentertid = new Button("Submit");
			removet = new Button("Remove");
			HBox teaid = new HBox();
			teaid.getChildren().addAll(entertid,bentertid,removet);
			
			Label displayte = new Label();
			
			Label degreelabel = new Label("------Edit Degree------");
			TextField newdegree = new TextField();
			newdegree.setPromptText("Enter new Degree");
			Button bnewdeg = new Button("Edit");
			HBox degrees = new HBox();
			degrees.getChildren().addAll(newdegree,bnewdeg);
			
			VBox xteacher = new VBox();
			xteacher.getChildren().addAll(teahead,teaid,displayte,degreelabel,degrees);
			
			VBox vl = new VBox();
			vl.getChildren().addAll(xstudent,xteacher);
			
			
			HBox mainh = new HBox();
			mainh.getChildren().addAll(vl,vr);
			
			Button blist = new Button("List");
			Button load = new Button("Load to MySQL Table oopschool");
			Button delete = new Button("Clear rows from oopschool");
			list = new TextArea("School to be displayed");
			
			HBox sql = new HBox();
			sql.getChildren().addAll(blist,load,delete);
			
			VBox mainv = new VBox();
			mainv.getChildren().addAll(mainh,sql,list);

			//
			//   BUTTON FUNCTIONALITY
			//
			load.setOnAction(e -> {
				controller.addData();
			});
			delete.setOnAction(e -> {
				controller.clearData();
			});
			
			
			blist.setOnAction(e -> {
				String newlist = controller.list();
				list.setText(newlist);
			});
			bentersid.setOnAction(e -> {
				Student found = controller.findStudent(entersid.getText());
				displayst.setText(found.toString());
			});
			removes.setOnAction(e -> {
				controller.removeStudent(entersid.getText());
				displayst.setText("REMOVED");
			});
			baddmod.setOnAction(e ->{
				controller.changeModule(entersid.getText(), addmod.getText(), modgrade.getText());
				displayst.setText(controller.getStudentString(entersid.getText()));
			});
			modremove.setOnAction(e -> {
				controller.remModule(entersid.getText(), addmod.getText());
				displayst.setText(controller.getStudentString(entersid.getText()));
			});
			
			bentertid.setOnAction(e ->{
				Teacher found = controller.findTeacher(entertid.getText());
				displayte.setText(found.toString());
			});
			removet.setOnAction(e -> {
				controller.removeTeacher(entertid.getText());
				displayte.setText("REMOVED");
			});
			bnewdeg.setOnAction(e -> {
				controller.changeDegree(entertid.getText(), newdegree.getText());
				displayte.setText(controller.getTeacherString(entertid.getText()));
			});
			
			
			createc.setOnAction(e -> controller.addClass(classname.getText()));
			removec.setOnAction(e -> controller.removeClass(classname.getText()));
			
			addt.setOnAction(e -> {
				if(tmiddle.getText()==null)	{
					controller.addTeacher(tfirst.getText(), tlast.getText(),
								temail.getText(), tphone.getText(), degree.getText());
				}
				else {
					controller.addTeacher(tfirst.getText(), tmiddle.getText(), tlast.getText(),
							temail.getText(), tphone.getText(), degree.getText());
				}
			});
			
			
			registers.setOnAction(e -> {
				if(middle.getText()==null) {
					controller.addStudent(first.getText(), last.getText(), email.getText(),
							phone.getText(), dob.getText(), sclass.getText());
				}
				else {
					controller.addStudent(first.getText(), middle.getText(), last.getText(), email.getText(),
							phone.getText(), dob.getText(), sclass.getText());
				}
			});
				
			
			mainPane.setCenter(mainv);
			
			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());
			mainPane.setPadding(new Insets(10,10,10,10));
			
			root.getChildren().add(mainPane);
			
			primaryStage.setTitle("School Database");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
