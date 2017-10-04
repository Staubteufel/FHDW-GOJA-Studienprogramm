package viewClient;

import view.*;
import view.objects.ViewRoot;
import view.objects.ViewObjectInTree;

import view.visitor.AnythingStandardVisitor;

import java.util.Optional;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;


import com.sun.javafx.geom.Point2D;

import common.IconConstants;

import javax.swing.tree.TreeModel;


public class AdminServerClientView extends BorderPane implements ExceptionAndEventHandler{

	private ConnectionMaster 		 connection;
	private ExceptionAndEventHandler parent;	
	private AdminServerView 		 		 service;

	/**
	 * This is the default constructor
	 */
	public AdminServerClientView( ExceptionAndEventHandler parent, AdminServerView service) {
		super();
		this.parent = parent;
		this.service = service;
		this.initialize();
	}
	@SuppressWarnings("unused")
	private AdminServerView getService(){
		return this.service;
	}
	private void initialize() {
        this.setCenter( this.getMainSplitPane());
        if( !WithStaticOperations && this.getMainToolBar().getItems().size() > 0){
        	this.setTop( this.getMainToolBar() );
        }
	}
	private ToolBar mainToolBar = null;
	private ToolBar getMainToolBar() {
		if( this.mainToolBar == null){
			this.mainToolBar = new ToolBar();
			for( Button current : this.getToolButtonsForStaticOperations()) {
				this.mainToolBar.getItems().add( current );
			}
		}
		return this.mainToolBar;
	}
	private SplitPane mainSplitPane = null;
	private SplitPane getMainSplitPane() {
		if( this.mainSplitPane == null) {
			this.mainSplitPane = new SplitPane();
			this.mainSplitPane.setOrientation( Orientation.HORIZONTAL);
			this.mainSplitPane.getItems().addAll( this.getNavigationSplitPane(), this.getTitledDetailsPane() );	
			this.mainSplitPane.setDividerPosition( 0, 0.5);
			this.mainSplitPane.prefHeightProperty().bind( this.heightProperty());
			this.mainSplitPane.prefWidthProperty().bind( this.widthProperty());
		}
		return this.mainSplitPane;
	}
	private SplitPane navigationSplitPane = null;
	private SplitPane getNavigationSplitPane(){
		if( this.navigationSplitPane == null ){
			this.navigationSplitPane = new SplitPane();
			this.navigationSplitPane.setOrientation( Orientation.VERTICAL);
			this.navigationSplitPane.getItems().addAll( this.getNavigationPanel(), this.getErrorPanel());
			this.navigationSplitPane.prefHeightProperty().bind( this.getMainSplitPane().heightProperty());
			this.navigationSplitPane.setDividerPosition( 0, 1.0);
			this.navigationSplitPane.heightProperty().addListener(new ChangeListener<Number>() {
				public void changed(
						ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if(! getErrorPanel().isVisible()) {						
						navigationSplitPane.setDividerPosition(0, 1.0);
					} else {						
						navigationSplitPane.setDividerPosition(0, 0.7);
					}
				}
			});
			this.getErrorPanel().setMinHeight(0);
		}
		return this.navigationSplitPane;
	}
	private TitledPane treePanel = null;
	private TitledPane getNavigationPanel() {
		if( this.treePanel == null) {
			this.treePanel = new TitledPane( GUIConstants.NaviationTitle, this.getNavigationTree() );
			this.treePanel.setCollapsible( false );
			this.treePanel.prefHeightProperty().bind( this.getNavigationSplitPane().heightProperty());
		}
		return treePanel;
	}
	private TitledPane errorPanel = null;
	private TitledPane getErrorPanel(){
		if( this.errorPanel == null){
			this.errorPanel = new TitledPane( GUIConstants.ErrorTitle, this.getErrorTree());
			this.errorPanel.setCollapsible( false );
			this.errorPanel.setVisible( false );
		}
		return this.errorPanel;
	}

	private TreeRefresh errorTree = null;
	private TreeRefresh getErrorTree(){
		if( this.errorTree == null){
			this.errorTree = new TreeRefresh(parent);
			this.errorTree.setOnContextMenuRequested( new EventHandler<ContextMenuEvent>() {
				public void handle(ContextMenuEvent e) {
					tryShowContextMenu( e, errorTree, false);					
				}
			});
		}
		return this.errorTree;
	}
	private void setErrors( TreeModel errors){
		this.getErrorPanel().setVisible(true);
		this.getErrorTree().setModel( errors );
		this.getNavigationSplitPane().setDividerPosition(0, 0.7);
	}
	private void setNoErrors(){
		this.getErrorPanel().setVisible(false);
        this.getNavigationSplitPane().setDividerPosition(0, 1.0);
	}
	private TitledPane titledDetailsPane = null;
	private TitledPane getTitledDetailsPane() {
		if( this.titledDetailsPane == null ){
			this.titledDetailsPane = new TitledPane();
			this.titledDetailsPane.setText( GUIConstants.DetailsTitle);
			this.titledDetailsPane.setCollapsible(false);			
			this.titledDetailsPane.prefHeightProperty().bind(this.getMainSplitPane().heightProperty());
		}
		return this.titledDetailsPane;		
	}	
	private TreeRefresh navigationTree = null;
	private TreeRefresh getNavigationTree() {
		if( this.navigationTree == null) {
			this.navigationTree = new TreeRefresh( parent );
			this.navigationTree.getSelectionModel().setSelectionMode( SelectionMode.SINGLE);
			this.navigationTree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<ViewObjectInTree>>() {
				public void changed(
					ObservableValue<? extends TreeItem<ViewObjectInTree>> observable,
					TreeItem<ViewObjectInTree> oldValue,
					TreeItem<ViewObjectInTree> newValue) {
					if( menu !=null) menu.hide();
					if( newValue != null ){						
						setDetailsTable( (Anything) newValue.getValue().getWrappedObject());				
					}
				}
			});
			this.navigationTree.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
				public void handle(ContextMenuEvent e) {
					tryShowContextMenu( e, navigationTree, WithStaticOperations);					
				}
			});
			navigationTree.setOnKeyReleased( new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if( event.getCode() == KeyCode.F5 ){
						Platform.runLater( new Runnable() {
							public void run() {								
								try {
									getNavigationTree().refreshTree();
								} catch (ModelException e) {
									handleException(e);
								}			
							}
						});
					}
				}
			});
		}
		return this.navigationTree;
	}
	private DetailPanel currentDetails = null;
	protected void setDetailsTable( Anything object) {
		this.getTitledDetailsPane().setVisible( false );
		if (object == null && this.getConnection() != null) object = this.getConnection().getAdminServerView();
		if (object == null){
			this.currentDetails = getNoDetailsPanel();
		}else{
			try {
				this.currentDetails = this.getDetailView(object);
			} catch (ModelException e) {
				this.handleException(e);
				this.currentDetails = null;
			}
			if(this.currentDetails == null) this.currentDetails = getStandardDetailsTable(object);
		}
		this.getTitledDetailsPane().setContent( this.currentDetails );
		this.getTitledDetailsPane().setVisible( true );
		this.currentDetails.prefWidthProperty().bind( this.getTitledDetailsPane().widthProperty() );
	}

	private DetailPanel getDetailView(final Anything anything) throws ModelException {
		class PanelDecider extends AnythingStandardVisitor {

			private DetailPanel result;
			
			public DetailPanel getResult() {
				return this.result;
			}
			protected void standardHandling(Anything Anything) throws ModelException {
				this.result = null;
			}
		}
		PanelDecider decider = new PanelDecider();
		anything.accept(decider);
		return decider.getResult();
	}
	private NoDetailPanel noDetailPanel = null;
	public DetailPanel getNoDetailsPanel() {
		if( this.noDetailPanel == null) this.noDetailPanel = new NoDetailPanel(this);
		return noDetailPanel;
	}
	private ContextMenu menu = null;
	protected void tryShowContextMenu( ContextMenuEvent e, TreeRefresh tree, boolean withStaticOperations) {
		if( this.menu !=null ) this.menu.hide();
		SelectionModel<TreeItem<ViewObjectInTree>> selMod = tree.getSelectionModel();
		ViewObjectInTree selVal = selMod.getSelectedItem().getValue();
		ViewRoot selected = selVal.getWrappedObject();
		this.menu = this.getContextMenu( selected, withStaticOperations , new Point2D((float)e.getScreenX(), (float)e.getScreenY() ) );
		if( this.menu.getItems().size() > 0) {
			this.menu.show( this.getNavigationPanel(),  e.getScreenX(), e.getScreenY() );
		}
	}
	
	private DetailPanel getStandardDetailsTable(Anything object) {
		try {
			return DefaultDetailPanel.getStandardDetailPanel(object,this);
		} catch (ModelException e) {
			this.handleException(e);
			return new NoDetailPanel(this);
		}
	}

	public void setConnection(ConnectionMaster connection){
		this.connection = connection;
	}
	public AdminServerConnection getConnection(){
        	return (AdminServerConnection)this.connection;
	}
	/** Is called by the refresher thread if the server object has changed
	**/
	public void handleRefresh(){
		Platform.runLater(new Runnable() {
			public void run(){
				try {
					getNavigationTree().refreshTree();
					java.util.Vector<?> errors = getConnection().getAdminServerView().getErrors();
					if (errors.size() >0 )setErrors( new ListRoot(errors));
					else setNoErrors();
				} catch (ModelException e) {
					handleException(e);
				}			
			}
		});
	}
	/** Is called only once after the connection has been established
	**/
	public void initializeConnection(){
		Platform.runLater( new  Runnable() {
			public void run() {
				getNavigationTree().setModel((TreeModel) getConnection().getAdminServerView());	
				getNavigationTree().getRoot().setExpanded(true);
				getNavigationTree().getSelectionModel().select( getNavigationTree().getRoot());
			}
		});
	}
	public void handleException(ModelException exception) {
		this.parent.handleException(exception);
	}
	public void handleOKMessage(String message) {
		this.parent.handleOKMessage(message);
	}
	public void handleUserException(UserException exception) {
		this.parent.handleUserException(exception);	
	}	
    private javafx.geometry.Point2D getPointForView(){
    	javafx.geometry.Point2D result = getNavigationTree().localToScene( getNavigationTree().getWidth()/18
    				 + getNavigationTree().getScene().getWindow().getX() + getNavigationTree().getScene().getX()
	  																	 , getNavigationTree().getHeight()/18
				     + getNavigationTree().getScene().getWindow().getY() + getNavigationTree().getScene().getY() );
    	return result;    	
    }
	
	/* Menu and wizard section start */

	static boolean WithStaticOperations = false;


    interface MenuItemVisitor{
        ImageView handle(AddMGToMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem menuItem);
        ImageView handle(AddMGToSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem menuItem);
        ImageView handle(AddMWUToMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem menuItem);
        ImageView handle(AddMWWUToMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem menuItem);
        ImageView handle(AddSToSGPRMTRStudyGroupPRMTRStudentServerPRMTRMenuItem menuItem);
        ImageView handle(AddUToMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem menuItem);
        ImageView handle(ChangeCPPRMTRApprPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(CreateModuleGroupPRMTRStringPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(CreateMWUPRMTRStringPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(CreateMWWUPRMTRStringPRMTRFractionPRMTRMarkPRMTRMenuItem menuItem);
        ImageView handle(CreateStudentPRMTRStringPRMTRStringPRMTRStringPRMTRStringPRMTRDatePRMTRStudyGroupPRMTRMenuItem menuItem);
        ImageView handle(CreateStudyGroupPRMTRStringPRMTRStudyProgramPRMTRMenuItem menuItem);
        ImageView handle(CreateStudyProgramPRMTRStringPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(CreateUnitPRMTRStringPRMTRFractionPRMTRMenuItem menuItem);
        ImageView handle(FetchMPRMTRApprPRMTRMenuItem menuItem);
        ImageView handle(RemMGFromMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem menuItem);
        ImageView handle(RemMGFromSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem menuItem);
        ImageView handle(RemoveModuleGroupPRMTRModuleGroupPRMTRMenuItem menuItem);
        ImageView handle(RemMWUFromMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem menuItem);
        ImageView handle(RmvMWUPRMTRModuleWithUnitsPRMTRMenuItem menuItem);
        ImageView handle(RemMWWUFromMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem menuItem);
        ImageView handle(RmvMWOUPRMTRModuleWithoutUnitsPRMTRMenuItem menuItem);
        ImageView handle(RemoveStudyGroupPRMTRStudyGroupPRMTRMenuItem menuItem);
        ImageView handle(RemoveStudyProgramPRMTRStudyProgramPRMTRMenuItem menuItem);
        ImageView handle(RemUFromMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem menuItem);
        ImageView handle(RemoveUnitPRMTRUnitPRMTRMenuItem menuItem);
        ImageView handle(SetActiveSGPRMTRStudentServerPRMTRStudyGroupPRMTRMenuItem menuItem);
        ImageView handle(SorcMTSWiMWuUPRMTRModuleWithoutUnitsPRMTRMarkPRMTRStringPRMTRMenuItem menuItem);
        ImageView handle(SorcMTSWiUPRMTRUnitPRMTRThirdMarkPRMTRStringPRMTRMenuItem menuItem);
    }
    private abstract class AdminServerMenuItem extends MenuItem{
        private AdminServerMenuItem(){
            this.setGraphic(getIconForMenuItem(this));
        }
        abstract protected ImageView accept(MenuItemVisitor visitor);
    }
    private class AddMGToMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddMGToSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddMWUToMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddMWWUToMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddSToSGPRMTRStudyGroupPRMTRStudentServerPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class AddUToMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class ChangeCPPRMTRApprPRMTRFractionPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateModuleGroupPRMTRStringPRMTRFractionPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateMWUPRMTRStringPRMTRFractionPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateMWWUPRMTRStringPRMTRFractionPRMTRMarkPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateStudentPRMTRStringPRMTRStringPRMTRStringPRMTRStringPRMTRDatePRMTRStudyGroupPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateStudyGroupPRMTRStringPRMTRStudyProgramPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateStudyProgramPRMTRStringPRMTRFractionPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class CreateUnitPRMTRStringPRMTRFractionPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class FetchMPRMTRApprPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemMGFromMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemMGFromSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveModuleGroupPRMTRModuleGroupPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemMWUFromMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RmvMWUPRMTRModuleWithUnitsPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemMWWUFromMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RmvMWOUPRMTRModuleWithoutUnitsPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveStudyGroupPRMTRStudyGroupPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveStudyProgramPRMTRStudyProgramPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemUFromMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class RemoveUnitPRMTRUnitPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class SetActiveSGPRMTRStudentServerPRMTRStudyGroupPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class SorcMTSWiMWuUPRMTRModuleWithoutUnitsPRMTRMarkPRMTRStringPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private class SorcMTSWiUPRMTRUnitPRMTRThirdMarkPRMTRStringPRMTRMenuItem extends AdminServerMenuItem{
        protected ImageView accept(MenuItemVisitor visitor){
            return visitor.handle(this);
        }
    }
    private java.util.Vector<javafx.scene.control.Button> getToolButtonsForStaticOperations() {
        java.util.Vector<javafx.scene.control.Button> result = new java.util.Vector<javafx.scene.control.Button>();
        javafx.scene.control.Button currentButton = null;
        currentButton = new javafx.scene.control.Button("CreateModuleGroup ... ");
        currentButton.setGraphic(new CreateModuleGroupPRMTRStringPRMTRFractionPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateModuleGroupStringFractionMssgWizard wizard = new AdminServerCreateModuleGroupStringFractionMssgWizard("CreateModuleGroup");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        result.add(currentButton);
        currentButton = new javafx.scene.control.Button("CreateModuleWithUnits ... ");
        currentButton.setGraphic(new CreateMWUPRMTRStringPRMTRFractionPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateMWUStringFractionMssgWizard wizard = new AdminServerCreateMWUStringFractionMssgWizard("CreateModuleWithUnits");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        result.add(currentButton);
        currentButton = new javafx.scene.control.Button("CreateModuleWithoutUnits ... ");
        currentButton.setGraphic(new CreateMWWUPRMTRStringPRMTRFractionPRMTRMarkPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateMWWUStringFractionMarkMssgWizard wizard = new AdminServerCreateMWWUStringFractionMarkMssgWizard("CreateModuleWithoutUnits");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        result.add(currentButton);
        currentButton = new javafx.scene.control.Button("CreateStudent ... ");
        currentButton.setGraphic(new CreateStudentPRMTRStringPRMTRStringPRMTRStringPRMTRStringPRMTRDatePRMTRStudyGroupPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateStudentStringStringStringStringDateStudyGroupMssgWizard wizard = new AdminServerCreateStudentStringStringStringStringDateStudyGroupMssgWizard("CreateStudent");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        result.add(currentButton);
        currentButton = new javafx.scene.control.Button("CreateStudyGroup ... ");
        currentButton.setGraphic(new CreateStudyGroupPRMTRStringPRMTRStudyProgramPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateStudyGroupStringStudyProgramMssgWizard wizard = new AdminServerCreateStudyGroupStringStudyProgramMssgWizard("CreateStudyGroup");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        result.add(currentButton);
        currentButton = new javafx.scene.control.Button("CreateStudyProgramm ... ");
        currentButton.setGraphic(new CreateStudyProgramPRMTRStringPRMTRFractionPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateStudyProgramStringFractionMssgWizard wizard = new AdminServerCreateStudyProgramStringFractionMssgWizard("CreateStudyProgramm");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        result.add(currentButton);
        currentButton = new javafx.scene.control.Button("CreateUnit ... ");
        currentButton.setGraphic(new CreateUnitPRMTRStringPRMTRFractionPRMTRMenuItem().getGraphic());
        currentButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateUnitStringFractionMssgWizard wizard = new AdminServerCreateUnitStringFractionMssgWizard("CreateUnit");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        result.add(currentButton);
        return result;
    }
    private ContextMenu getContextMenu(final ViewRoot selected, final boolean withStaticOperations, final Point2D menuPos) {
        final ContextMenu result = new ContextMenu();
        MenuItem item = null;
        item = new CreateModuleGroupPRMTRStringPRMTRFractionPRMTRMenuItem();
        item.setText("(S) CreateModuleGroup ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateModuleGroupStringFractionMssgWizard wizard = new AdminServerCreateModuleGroupStringFractionMssgWizard("CreateModuleGroup");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        item = new CreateMWUPRMTRStringPRMTRFractionPRMTRMenuItem();
        item.setText("(S) CreateModuleWithUnits ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateMWUStringFractionMssgWizard wizard = new AdminServerCreateMWUStringFractionMssgWizard("CreateModuleWithUnits");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        item = new CreateMWWUPRMTRStringPRMTRFractionPRMTRMarkPRMTRMenuItem();
        item.setText("(S) CreateModuleWithoutUnits ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateMWWUStringFractionMarkMssgWizard wizard = new AdminServerCreateMWWUStringFractionMarkMssgWizard("CreateModuleWithoutUnits");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        item = new CreateStudentPRMTRStringPRMTRStringPRMTRStringPRMTRStringPRMTRDatePRMTRStudyGroupPRMTRMenuItem();
        item.setText("(S) CreateStudent ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateStudentStringStringStringStringDateStudyGroupMssgWizard wizard = new AdminServerCreateStudentStringStringStringStringDateStudyGroupMssgWizard("CreateStudent");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        item = new CreateStudyGroupPRMTRStringPRMTRStudyProgramPRMTRMenuItem();
        item.setText("(S) CreateStudyGroup ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateStudyGroupStringStudyProgramMssgWizard wizard = new AdminServerCreateStudyGroupStringStudyProgramMssgWizard("CreateStudyGroup");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        item = new CreateStudyProgramPRMTRStringPRMTRFractionPRMTRMenuItem();
        item.setText("(S) CreateStudyProgramm ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateStudyProgramStringFractionMssgWizard wizard = new AdminServerCreateStudyProgramStringFractionMssgWizard("CreateStudyProgramm");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        item = new CreateUnitPRMTRStringPRMTRFractionPRMTRMenuItem();
        item.setText("(S) CreateUnit ... ");
        item.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(javafx.event.ActionEvent e) {
                final AdminServerCreateUnitStringFractionMssgWizard wizard = new AdminServerCreateUnitStringFractionMssgWizard("CreateUnit");
                wizard.setWidth(getNavigationPanel().getWidth());
                wizard.setX( getPointForView().getX());
                wizard.setY( getPointForView().getY());
                wizard.showAndWait();
            }
        });
        if (withStaticOperations) result.getItems().add(item);
        if (selected != null){
            try {
                this.setPreCalculatedFilters(this.getConnection().adminServer_Menu_Filter((Anything)selected));
            } catch (ModelException me){
                this.handleException(me);
                return result;
            }
            if (selected instanceof StudyProgramView){
                item = new AddMGToSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem();
                item.setText("AddModuleGroupToStudyProgram ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerAddMGToSPStudyProgramModuleGroupMssgWizard wizard = new AdminServerAddMGToSPStudyProgramModuleGroupMssgWizard("AddModuleGroupToStudyProgram");
                        wizard.setFirstArgument((StudyProgramView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new RemMGFromSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem();
                item.setText("RemoveModuleGroupFromStudyProgram ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerRemMGFromSPStudyProgramModuleGroupMssgWizard wizard = new AdminServerRemMGFromSPStudyProgramModuleGroupMssgWizard("RemoveModuleGroupFromStudyProgram");
                        wizard.setFirstArgument((StudyProgramView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new RemoveStudyProgramPRMTRStudyProgramPRMTRMenuItem();
                item.setText("RemoveStudyProgram");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("RemoveStudyProgram" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().removeStudyProgram((StudyProgramView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }catch (AlreadyInUseException userException){
                                ReturnValueView view = new ReturnValueView(userException.getMessage(), new javafx.geometry.Dimension2D(getNavigationPanel().getWidth()*8/9,getNavigationPanel().getHeight()*8/9));
                                view.setX( getPointForView().getX() );
                                view.setY( getPointForView().getY() );
                                view.showAndWait();
                                getConnection().setEagerRefresh();
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof StudentServerView){
                item = new SetActiveSGPRMTRStudentServerPRMTRStudyGroupPRMTRMenuItem();
                item.setText("SetActiveStudyGroup ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerSetActiveSGStudentServerStudyGroupMssgWizard wizard = new AdminServerSetActiveSGStudentServerStudyGroupMssgWizard("SetActiveStudyGroup");
                        wizard.setFirstArgument((StudentServerView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof StudyGroupView){
                item = new AddSToSGPRMTRStudyGroupPRMTRStudentServerPRMTRMenuItem();
                item.setText("AddStudentToStudyGroup ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerAddSToSGStudyGroupStudentServerMssgWizard wizard = new AdminServerAddSToSGStudyGroupStudentServerMssgWizard("AddStudentToStudyGroup");
                        wizard.setFirstArgument((StudyGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new RemoveStudyGroupPRMTRStudyGroupPRMTRMenuItem();
                item.setText("RemoveStudyGroup");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("RemoveStudyGroup" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().removeStudyGroup((StudyGroupView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }catch (AlreadyInUseException userException){
                                ReturnValueView view = new ReturnValueView(userException.getMessage(), new javafx.geometry.Dimension2D(getNavigationPanel().getWidth()*8/9,getNavigationPanel().getHeight()*8/9));
                                view.setX( getPointForView().getX() );
                                view.setY( getPointForView().getY() );
                                view.showAndWait();
                                getConnection().setEagerRefresh();
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleWithUnitsView){
                item = new AddUToMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem();
                item.setText("AddUnitToModuleWithUnits ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerAddUToMWUModuleWithUnitsUnitMssgWizard wizard = new AdminServerAddUToMWUModuleWithUnitsUnitMssgWizard("AddUnitToModuleWithUnits");
                        wizard.setFirstArgument((ModuleWithUnitsView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new RmvMWUPRMTRModuleWithUnitsPRMTRMenuItem();
                item.setText("RemoveModuleWithUnits");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("RemoveModuleWithUnits" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().rmvMWU((ModuleWithUnitsView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }catch (AlreadyInUseException userException){
                                ReturnValueView view = new ReturnValueView(userException.getMessage(), new javafx.geometry.Dimension2D(getNavigationPanel().getWidth()*8/9,getNavigationPanel().getHeight()*8/9));
                                view.setX( getPointForView().getX() );
                                view.setY( getPointForView().getY() );
                                view.showAndWait();
                                getConnection().setEagerRefresh();
                            }
                        }
                    }
                });
                result.getItems().add(item);
                item = new RemUFromMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem();
                item.setText("RemoveUnitFromModuleWithUnits ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerRemUFromMWUModuleWithUnitsUnitMssgWizard wizard = new AdminServerRemUFromMWUModuleWithUnitsUnitMssgWizard("RemoveUnitFromModuleWithUnits");
                        wizard.setFirstArgument((ModuleWithUnitsView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleGroupView){
                item = new AddMGToMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem();
                item.setText("AddModuleGroupToModuleGroup ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerAddMGToMGModuleGroupModuleGroupMssgWizard wizard = new AdminServerAddMGToMGModuleGroupModuleGroupMssgWizard("AddModuleGroupToModuleGroup");
                        wizard.setFirstArgument((ModuleGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new AddMWUToMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem();
                item.setText("AddModuleWithUnitsToModuleGroup ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerAddMWUToMGModuleGroupModuleWithUnitsMssgWizard wizard = new AdminServerAddMWUToMGModuleGroupModuleWithUnitsMssgWizard("AddModuleWithUnitsToModuleGroup");
                        wizard.setFirstArgument((ModuleGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new AddMWWUToMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem();
                item.setText("AddModuleWithoutUnitsToModuleGroup ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerAddMWWUToMGModuleGroupModuleWithoutUnitsMssgWizard wizard = new AdminServerAddMWWUToMGModuleGroupModuleWithoutUnitsMssgWizard("AddModuleWithoutUnitsToModuleGroup");
                        wizard.setFirstArgument((ModuleGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new RemMGFromMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem();
                item.setText("RemoveModuleGroupFromModuleGroup ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerRemMGFromMGModuleGroupModuleGroupMssgWizard wizard = new AdminServerRemMGFromMGModuleGroupModuleGroupMssgWizard("RemoveModuleGroupFromModuleGroup");
                        wizard.setFirstArgument((ModuleGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new RemoveModuleGroupPRMTRModuleGroupPRMTRMenuItem();
                item.setText("RemoveModuleGroup");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("RemoveModuleGroup" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().removeModuleGroup((ModuleGroupView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }catch (AlreadyInUseException userException){
                                ReturnValueView view = new ReturnValueView(userException.getMessage(), new javafx.geometry.Dimension2D(getNavigationPanel().getWidth()*8/9,getNavigationPanel().getHeight()*8/9));
                                view.setX( getPointForView().getX() );
                                view.setY( getPointForView().getY() );
                                view.showAndWait();
                                getConnection().setEagerRefresh();
                            }
                        }
                    }
                });
                result.getItems().add(item);
                item = new RemMWUFromMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem();
                item.setText("RemoveModuleWithUnitsFromModuleGroup ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerRemMWUFromMGModuleGroupModuleWithUnitsMssgWizard wizard = new AdminServerRemMWUFromMGModuleGroupModuleWithUnitsMssgWizard("RemoveModuleWithUnitsFromModuleGroup");
                        wizard.setFirstArgument((ModuleGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new RemMWWUFromMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem();
                item.setText("RemoveModuleWithoutUnitsFromModuleGroup ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerRemMWWUFromMGModuleGroupModuleWithoutUnitsMssgWizard wizard = new AdminServerRemMWWUFromMGModuleGroupModuleWithoutUnitsMssgWizard("RemoveModuleWithoutUnitsFromModuleGroup");
                        wizard.setFirstArgument((ModuleGroupView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof UnitView){
                item = new RemoveUnitPRMTRUnitPRMTRMenuItem();
                item.setText("RemoveUnit");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("RemoveUnit" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().removeUnit((UnitView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }catch (UnitIsAlreadyPartOfAModuleWithUnitsException userException){
                                ReturnValueView view = new ReturnValueView(userException.getMessage(), new javafx.geometry.Dimension2D(getNavigationPanel().getWidth()*8/9,getNavigationPanel().getHeight()*8/9));
                                view.setX( getPointForView().getX() );
                                view.setY( getPointForView().getY() );
                                view.showAndWait();
                                getConnection().setEagerRefresh();
                            }catch (AlreadyInUseException userException){
                                ReturnValueView view = new ReturnValueView(userException.getMessage(), new javafx.geometry.Dimension2D(getNavigationPanel().getWidth()*8/9,getNavigationPanel().getHeight()*8/9));
                                view.setX( getPointForView().getX() );
                                view.setY( getPointForView().getY() );
                                view.showAndWait();
                                getConnection().setEagerRefresh();
                            }
                        }
                    }
                });
                result.getItems().add(item);
                item = new SorcMTSWiUPRMTRUnitPRMTRThirdMarkPRMTRStringPRMTRMenuItem();
                item.setText("SetOrChangeMarkToStudentWithUnit ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerSorcMTSWiUUnitThirdMarkStringMssgWizard wizard = new AdminServerSorcMTSWiUUnitThirdMarkStringMssgWizard("SetOrChangeMarkToStudentWithUnit");
                        wizard.setFirstArgument((UnitView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ApprView){
                item = new ChangeCPPRMTRApprPRMTRFractionPRMTRMenuItem();
                item.setText("ChangeCreditPoints ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerChangeCPApprFractionMssgWizard wizard = new AdminServerChangeCPApprFractionMssgWizard("ChangeCreditPoints");
                        wizard.setFirstArgument((ApprView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
                item = new FetchMPRMTRApprPRMTRMenuItem();
                item.setText("FetchMark");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("FetchMark" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                ViewRoot result = (ViewRoot)getConnection().fetchM((ApprView)selected);
                                getConnection().setEagerRefresh();
                                ReturnValueView view = new ReturnValueView(result, new javafx.geometry.Dimension2D(getNavigationPanel().getWidth()*8/9,getNavigationPanel().getHeight()*8/9), AdminServerClientView.this);
                                view.setX( getPointForView().getX() );
                                view.setY( getPointForView().getY() );
                                view.showAndWait();
                            }catch(ModelException me){
                                handleException(me);
                            }catch (NotAllowedOperationOnPrototypeException userException){
                                ReturnValueView view = new ReturnValueView(userException.getMessage(), new javafx.geometry.Dimension2D(getNavigationPanel().getWidth()*8/9,getNavigationPanel().getHeight()*8/9));
                                view.setX( getPointForView().getX() );
                                view.setY( getPointForView().getY() );
                                view.showAndWait();
                                getConnection().setEagerRefresh();
                            }
                        }
                    }
                });
                result.getItems().add(item);
            }
            if (selected instanceof ModuleWithoutUnitsView){
                item = new RmvMWOUPRMTRModuleWithoutUnitsPRMTRMenuItem();
                item.setText("RemoveModuleWithoutUnits");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        Alert confirm = new Alert(AlertType.CONFIRMATION);
                        confirm.setTitle(GUIConstants.ConfirmButtonText);
                        confirm.setHeaderText(null);
                        confirm.setContentText("RemoveModuleWithoutUnits" + GUIConstants.ConfirmQuestionMark);
                        confirm.setX( getPointForView().getX() );
                        confirm.setY( getPointForView().getY() );
                        Optional<ButtonType> buttonResult = confirm.showAndWait();
                        if (buttonResult.get() == ButtonType.OK) {
                            try {
                                getConnection().rmvMWOU((ModuleWithoutUnitsView)selected);
                                getConnection().setEagerRefresh();
                                
                            }catch(ModelException me){
                                handleException(me);
                            }catch (AlreadyInUseException userException){
                                ReturnValueView view = new ReturnValueView(userException.getMessage(), new javafx.geometry.Dimension2D(getNavigationPanel().getWidth()*8/9,getNavigationPanel().getHeight()*8/9));
                                view.setX( getPointForView().getX() );
                                view.setY( getPointForView().getY() );
                                view.showAndWait();
                                getConnection().setEagerRefresh();
                            }
                        }
                    }
                });
                result.getItems().add(item);
                item = new SorcMTSWiMWuUPRMTRModuleWithoutUnitsPRMTRMarkPRMTRStringPRMTRMenuItem();
                item.setText("SetOrChangeMarkToStudentWithModuleWithoutUnits ... ");
                item.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(javafx.event.ActionEvent e) {
                        final AdminServerSorcMTSWiMWuUModuleWithoutUnitsMarkStringMssgWizard wizard = new AdminServerSorcMTSWiMWuUModuleWithoutUnitsMarkStringMssgWizard("SetOrChangeMarkToStudentWithModuleWithoutUnits");
                        wizard.setFirstArgument((ModuleWithoutUnitsView)selected);
                        wizard.setWidth(getNavigationPanel().getWidth());
                        wizard.setX( getPointForView().getX());
                        wizard.setY( getPointForView().getY());
                        wizard.showAndWait();
                    }
                });
                result.getItems().add(item);
            }
            
        }
        this.addNotGeneratedItems(result,selected);
        return result;
    }
    private String preCalculatedFilters = "";
    private String getPreCalculatedFilters() {
        return this.preCalculatedFilters;
    }
    private void setPreCalculatedFilters(String switchOff) {
        this.preCalculatedFilters = switchOff;
    }
    
	class AdminServerAddMGToMGModuleGroupModuleGroupMssgWizard extends Wizard {

		protected AdminServerAddMGToMGModuleGroupModuleGroupMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddMGToMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerAddMGToMGModuleGroupModuleGroupMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addMGToMG(firstArgument, (ModuleGroupView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(CycleException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel1 = new ObjectSelectionPanel("mG", "view.ModuleGroupView", null, this);
				getParametersPanel().getChildren().add(panel1);
				panel1.setBrowserRoot((ViewRoot)getConnection().mG_Path_In_AddMGToMG());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ModuleGroupView firstArgument; 
	
		public void setFirstArgument(ModuleGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerAddMGToSPStudyProgramModuleGroupMssgWizard extends Wizard {

		protected AdminServerAddMGToSPStudyProgramModuleGroupMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddMGToSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerAddMGToSPStudyProgramModuleGroupMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addMGToSP(firstArgument, (ModuleGroupView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel2 = new ObjectSelectionPanel("moduleGroup", "view.ModuleGroupView", null, this);
				getParametersPanel().getChildren().add(panel2);
				panel2.setBrowserRoot((ViewRoot)getConnection().moduleGroup_Path_In_AddMGToSP());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private StudyProgramView firstArgument; 
	
		public void setFirstArgument(StudyProgramView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerAddMWUToMGModuleGroupModuleWithUnitsMssgWizard extends Wizard {

		protected AdminServerAddMWUToMGModuleGroupModuleWithUnitsMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddMWUToMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerAddMWUToMGModuleGroupModuleWithUnitsMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addMWUToMG(firstArgument, (ModuleWithUnitsView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(CycleException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel3 = new ObjectSelectionPanel("moduleWithUnits", "view.ModuleWithUnitsView", null, this);
				getParametersPanel().getChildren().add(panel3);
				panel3.setBrowserRoot((ViewRoot)getConnection().moduleWithUnits_Path_In_AddMWUToMG());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ModuleGroupView firstArgument; 
	
		public void setFirstArgument(ModuleGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerAddMWWUToMGModuleGroupModuleWithoutUnitsMssgWizard extends Wizard {

		protected AdminServerAddMWWUToMGModuleGroupModuleWithoutUnitsMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddMWWUToMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerAddMWWUToMGModuleGroupModuleWithoutUnitsMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addMWWUToMG(firstArgument, (ModuleWithoutUnitsView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(CycleException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel4 = new ObjectSelectionPanel("moduleWithoutUnits", "view.ModuleWithoutUnitsView", null, this);
				getParametersPanel().getChildren().add(panel4);
				panel4.setBrowserRoot((ViewRoot)getConnection().moduleWithoutUnits_Path_In_AddMWWUToMG());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ModuleGroupView firstArgument; 
	
		public void setFirstArgument(ModuleGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerAddSToSGStudyGroupStudentServerMssgWizard extends Wizard {

		protected AdminServerAddSToSGStudyGroupStudentServerMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddSToSGPRMTRStudyGroupPRMTRStudentServerPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerAddSToSGStudyGroupStudentServerMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addSToSG(firstArgument, (StudentServerView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel5 = new ObjectSelectionPanel("student", "view.StudentServerView", null, this);
				getParametersPanel().getChildren().add(panel5);
				panel5.setBrowserRoot((ViewRoot)getConnection().student_Path_In_AddSToSG());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private StudyGroupView firstArgument; 
	
		public void setFirstArgument(StudyGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerAddUToMWUModuleWithUnitsUnitMssgWizard extends Wizard {

		protected AdminServerAddUToMWUModuleWithUnitsUnitMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new AddUToMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerAddUToMWUModuleWithUnitsUnitMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().addUToMWU(firstArgument, (UnitView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(ThereIsAlreadyAStudyGroupException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(UnitIsAlreadyPartOfAModuleWithUnitsException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel6 = new ObjectSelectionPanel("unit", "view.UnitView", null, this);
				getParametersPanel().getChildren().add(panel6);
				panel6.setBrowserRoot((ViewRoot)getConnection().unit_Path_In_AddUToMWU());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ModuleWithUnitsView firstArgument; 
	
		public void setFirstArgument(ModuleWithUnitsView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerChangeCPApprFractionMssgWizard extends Wizard {

		protected AdminServerChangeCPApprFractionMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new ChangeCPPRMTRApprPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerChangeCPApprFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().changeCP(firstArgument, ((FractionSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ApprView firstArgument; 
	
		public void setFirstArgument(ApprView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				final SelectionPanel selectionPanel0 = (SelectionPanel)getParametersPanel().getChildren().get(0);
				selectionPanel0.preset(firstArgument.getCreditPoints());
				if (!selectionPanel0.check()) selectionPanel0.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class AdminServerCreateMWUStringFractionMssgWizard extends Wizard {

		protected AdminServerCreateMWUStringFractionMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateMWUPRMTRStringPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerCreateMWUStringFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createMWU(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(NameAlreadyExistsException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class AdminServerCreateMWWUStringFractionMarkMssgWizard extends Wizard {

		protected AdminServerCreateMWWUStringFractionMarkMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateMWWUPRMTRStringPRMTRFractionPRMTRMarkPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerCreateMWWUStringFractionMarkMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createMWWU(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(1)).getResult(),
									(Mark)((ObjectSelectionPanel)getParametersPanel().getChildren().get(2)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(NameAlreadyExistsException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));
			try{
				final ObjectSelectionPanel panel7 = new ObjectSelectionPanel("markType", "view.Mark", null, this);
				getParametersPanel().getChildren().add(panel7);
				panel7.setBrowserRoot(new ListRoot(getConnection().markType_Path_In_CreateMWWU()));
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class AdminServerCreateModuleGroupStringFractionMssgWizard extends Wizard {

		protected AdminServerCreateModuleGroupStringFractionMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateModuleGroupPRMTRStringPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerCreateModuleGroupStringFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createModuleGroup(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(NameAlreadyExistsException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class AdminServerCreateStudentStringStringStringStringDateStudyGroupMssgWizard extends Wizard {

		protected AdminServerCreateStudentStringStringStringStringDateStudyGroupMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateStudentPRMTRStringPRMTRStringPRMTRStringPRMTRStringPRMTRDatePRMTRStudyGroupPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerCreateStudentStringStringStringStringDateStudyGroupMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createStudent(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(2)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(3)).getResult(),
									((DateSelectionPanel)getParametersPanel().getChildren().get(4)).getResult(),
									(StudyGroupView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(5)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(MatricalNumberAlreadyUsed e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(CreditPointInformationIsNotConsistent e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new StringSelectionPanel("matricalNumber", this));
			getParametersPanel().getChildren().add(new StringSelectionPanel("password", this));
			getParametersPanel().getChildren().add(new StringSelectionPanel("forename", this));
			getParametersPanel().getChildren().add(new StringSelectionPanel("surname", this));
			getParametersPanel().getChildren().add(new DateSelectionPanel("dateOfBirth", this));
			try{
				final ObjectSelectionPanel panel8 = new ObjectSelectionPanel("studyGroup", "view.StudyGroupView", null, this);
				getParametersPanel().getChildren().add(panel8);
				panel8.setBrowserRoot((ViewRoot)getConnection().studyGroup_Path_In_CreateStudent());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class AdminServerCreateStudyGroupStringStudyProgramMssgWizard extends Wizard {

		protected AdminServerCreateStudyGroupStringStudyProgramMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateStudyGroupPRMTRStringPRMTRStudyProgramPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerCreateStudyGroupStringStudyProgramMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createStudyGroup(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									(StudyProgramView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(NameAlreadyExistsException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(CreditPointInformationIsNotConsistent e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));
			try{
				final ObjectSelectionPanel panel9 = new ObjectSelectionPanel("studyProgram", "view.StudyProgramView", null, this);
				getParametersPanel().getChildren().add(panel9);
				panel9.setBrowserRoot((ViewRoot)getConnection().studyProgram_Path_In_CreateStudyGroup());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class AdminServerCreateStudyProgramStringFractionMssgWizard extends Wizard {

		protected AdminServerCreateStudyProgramStringFractionMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateStudyProgramPRMTRStringPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerCreateStudyProgramStringFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createStudyProgram(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(NameAlreadyExistsException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class AdminServerCreateUnitStringFractionMssgWizard extends Wizard {

		protected AdminServerCreateUnitStringFractionMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new CreateUnitPRMTRStringPRMTRFractionPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerCreateUnitStringFractionMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().createUnit(((StringSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(NameAlreadyExistsException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			getParametersPanel().getChildren().add(new StringSelectionPanel("name", this));
			getParametersPanel().getChildren().add(new FractionSelectionPanel("creditPoints", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class AdminServerRemMGFromMGModuleGroupModuleGroupMssgWizard extends Wizard {

		protected AdminServerRemMGFromMGModuleGroupModuleGroupMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemMGFromMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerRemMGFromMGModuleGroupModuleGroupMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().remMGFromMG(firstArgument, (ModuleGroupView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			final ObjectSelectionPanel panel10 = new ObjectSelectionPanel("mG", "view.ModuleGroupView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().mG_Path_In_RemMGFromMG((ModuleGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel10);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private ModuleGroupView firstArgument; 
	
		public void setFirstArgument(ModuleGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerRemMGFromSPStudyProgramModuleGroupMssgWizard extends Wizard {

		protected AdminServerRemMGFromSPStudyProgramModuleGroupMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemMGFromSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerRemMGFromSPStudyProgramModuleGroupMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().remMGFromSP(firstArgument, (ModuleGroupView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			final ObjectSelectionPanel panel11 = new ObjectSelectionPanel("moduleGroup", "view.ModuleGroupView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().moduleGroup_Path_In_RemMGFromSP((StudyProgramView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel11);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private StudyProgramView firstArgument; 
	
		public void setFirstArgument(StudyProgramView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerRemMWUFromMGModuleGroupModuleWithUnitsMssgWizard extends Wizard {

		protected AdminServerRemMWUFromMGModuleGroupModuleWithUnitsMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemMWUFromMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerRemMWUFromMGModuleGroupModuleWithUnitsMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().remMWUFromMG(firstArgument, (ModuleWithUnitsView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			final ObjectSelectionPanel panel12 = new ObjectSelectionPanel("moduleWithUnits", "view.ModuleWithUnitsView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().moduleWithUnits_Path_In_RemMWUFromMG((ModuleGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel12);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private ModuleGroupView firstArgument; 
	
		public void setFirstArgument(ModuleGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerRemMWWUFromMGModuleGroupModuleWithoutUnitsMssgWizard extends Wizard {

		protected AdminServerRemMWWUFromMGModuleGroupModuleWithoutUnitsMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemMWWUFromMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerRemMWWUFromMGModuleGroupModuleWithoutUnitsMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().remMWWUFromMG(firstArgument, (ModuleWithoutUnitsView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			final ObjectSelectionPanel panel13 = new ObjectSelectionPanel("moduleWithoutUnits", "view.ModuleWithoutUnitsView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().moduleWithoutUnits_Path_In_RemMWWUFromMG((ModuleGroupView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel13);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private ModuleGroupView firstArgument; 
	
		public void setFirstArgument(ModuleGroupView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerRemUFromMWUModuleWithUnitsUnitMssgWizard extends Wizard {

		protected AdminServerRemUFromMWUModuleWithUnitsUnitMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new RemUFromMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerRemUFromMWUModuleWithUnitsUnitMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().remUFromMWU(firstArgument, (UnitView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(AlreadyInUseException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			final ObjectSelectionPanel panel14 = new ObjectSelectionPanel("unit", "view.UnitView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().unit_Path_In_RemUFromMWU((ModuleWithUnitsView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel14);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private ModuleWithUnitsView firstArgument; 
	
		public void setFirstArgument(ModuleWithUnitsView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerSetActiveSGStudentServerStudyGroupMssgWizard extends Wizard {

		protected AdminServerSetActiveSGStudentServerStudyGroupMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new SetActiveSGPRMTRStudentServerPRMTRStudyGroupPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerSetActiveSGStudentServerStudyGroupMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().setActiveSG(firstArgument, (StudyGroupView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(NotInStudyGroupException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			final ObjectSelectionPanel panel15 = new ObjectSelectionPanel("studyGroup", "view.StudyGroupView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().studyGroup_Path_In_SetActiveSG((StudentServerView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}};
			getParametersPanel().getChildren().add(panel15);		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getChildren().get(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private StudentServerView firstArgument; 
	
		public void setFirstArgument(StudentServerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerSorcMTSWiMWuUModuleWithoutUnitsMarkStringMssgWizard extends Wizard {

		protected AdminServerSorcMTSWiMWuUModuleWithoutUnitsMarkStringMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new SorcMTSWiMWuUPRMTRModuleWithoutUnitsPRMTRMarkPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerSorcMTSWiMWuUModuleWithoutUnitsMarkStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().sorcMTSWiMWuU(firstArgument, (Mark)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(OtherTypeThanSettedException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(NotAllowedOperationOnPrototypeException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel16 = new ObjectSelectionPanel("mark", "view.Mark", null, this);
				getParametersPanel().getChildren().add(panel16);
				panel16.setBrowserRoot(new ListRoot(getConnection().mark_Path_In_SorcMTSWiMWuU()));
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }
			getParametersPanel().getChildren().add(new StringSelectionPanel("comment", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private ModuleWithoutUnitsView firstArgument; 
	
		public void setFirstArgument(ModuleWithoutUnitsView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class AdminServerSorcMTSWiUUnitThirdMarkStringMssgWizard extends Wizard {

		protected AdminServerSorcMTSWiUUnitThirdMarkStringMssgWizard(String operationName){
			super(AdminServerClientView.this);
			getOkButton().setText(operationName);
			getOkButton().setGraphic(new SorcMTSWiUPRMTRUnitPRMTRThirdMarkPRMTRStringPRMTRMenuItem ().getGraphic());
		}
		protected void initialize(){
			this.helpFileName = "AdminServerSorcMTSWiUUnitThirdMarkStringMssgWizard.help";
			super.initialize();		
		}
				
		protected void perform() {
			try {
				getConnection().sorcMTSWiU(firstArgument, (ThirdMarkView)((ObjectSelectionPanel)getParametersPanel().getChildren().get(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getChildren().get(1)).getResult());
				getConnection().setEagerRefresh();
				this.close();	
			} catch(ModelException me){
				handleException(me);
				this.close();
			}
			catch(NotAllowedOperationOnPrototypeException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		protected boolean isModifying () {
			return false;
		}
		protected void addParameters(){
			try{
				final ObjectSelectionPanel panel17 = new ObjectSelectionPanel("mark", "view.ThirdMarkView", null, this);
				getParametersPanel().getChildren().add(panel17);
				panel17.setBrowserRoot((ViewRoot)getConnection().mark_Path_In_SorcMTSWiU());
			}catch(ModelException me){;
				handleException(me);
				close();
				return;
			 }catch(UserException ue){;
				handleUserException(ue);
				close();
				return;
			 }
			getParametersPanel().getChildren().add(new StringSelectionPanel("comment", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private UnitView firstArgument; 
	
		public void setFirstArgument(UnitView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	/* Menu and wizard section end */
	
	private ImageView getIconForMenuItem(AdminServerMenuItem menuItem){
//		return new ImageView(new javafx.scene.image.Image("/viewResources/default.gif"));
		return menuItem.accept(new MenuItemVisitor() {
			
			public ImageView Add() {
				return new ImageView(new Image("/viewResources/add.png", 16, 16, true, true));
			}
			
			public ImageView CreateImg() {
				return new ImageView(new Image("/viewResources/create.png", 16, 16, true, true));
			}
			
			public ImageView RemoveImg() {
				return new ImageView(new Image("/viewResources/remove.png", 16, 16, true, true));
			}

			@Override
			public ImageView handle(AddMGToMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem menuItem) {
				return Add();
			}

			@Override
			public ImageView handle(AddMGToSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem menuItem) {
				return Add();
			}

			@Override
			public ImageView handle(AddMWUToMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem menuItem) {
				return Add();
			}

			@Override
			public ImageView handle(AddMWWUToMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem menuItem) {
				return Add();
			}

			@Override
			public ImageView handle(AddSToSGPRMTRStudyGroupPRMTRStudentServerPRMTRMenuItem menuItem) {
				return Add();
			}

			@Override
			public ImageView handle(AddUToMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem menuItem) {
				return Add();
			}

//			@Override
//			public ImageView handle(ChCPWithMWWUPRMTRModuleWithoutUnitsPRMTRFractionPRMTRMenuItem menuItem) {
//				return new ImageView(new Image("/viewResources/change.png", 16, 16, true, true));
//			}
//
//			@Override
//			public ImageView handle(ChCPWithUPRMTRUnitPRMTRFractionPRMTRMenuItem menuItem) {
//				return new ImageView(new Image("/viewResources/change.png", 16, 16, true, true));
//			}

			@Override
			public ImageView handle(CreateModuleGroupPRMTRStringPRMTRFractionPRMTRMenuItem menuItem) {
				return CreateImg();
			}

			@Override
			public ImageView handle(CreateMWUPRMTRStringPRMTRFractionPRMTRMenuItem menuItem) {
				return CreateImg();
			}

			@Override
			public ImageView handle(CreateMWWUPRMTRStringPRMTRFractionPRMTRMarkPRMTRMenuItem menuItem) {
				return CreateImg();
			}

			@Override
			public ImageView handle(
					CreateStudentPRMTRStringPRMTRStringPRMTRStringPRMTRStringPRMTRDatePRMTRStudyGroupPRMTRMenuItem menuItem) {
				return CreateImg();
			}

			@Override
			public ImageView handle(CreateStudyGroupPRMTRStringPRMTRStudyProgramPRMTRMenuItem menuItem) {
				return CreateImg();
			}

			@Override
			public ImageView handle(CreateStudyProgramPRMTRStringPRMTRFractionPRMTRMenuItem menuItem) {
				return CreateImg();
			}

			@Override
			public ImageView handle(CreateUnitPRMTRStringPRMTRFractionPRMTRMenuItem menuItem) {
				return CreateImg();
			}

			@Override
			public ImageView handle(FetchMPRMTRApprPRMTRMenuItem menuItem) {
				return new ImageView(new Image("/viewResources/fetch.png", 16, 16, true, true));
			}

			@Override
			public ImageView handle(RemMGFromMGPRMTRModuleGroupPRMTRModuleGroupPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RemMGFromSPPRMTRStudyProgramPRMTRModuleGroupPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RemoveModuleGroupPRMTRModuleGroupPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RemMWUFromMGPRMTRModuleGroupPRMTRModuleWithUnitsPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RmvMWUPRMTRModuleWithUnitsPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RemMWWUFromMGPRMTRModuleGroupPRMTRModuleWithoutUnitsPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RmvMWOUPRMTRModuleWithoutUnitsPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RemoveStudyGroupPRMTRStudyGroupPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RemoveStudyProgramPRMTRStudyProgramPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RemUFromMWUPRMTRModuleWithUnitsPRMTRUnitPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(RemoveUnitPRMTRUnitPRMTRMenuItem menuItem) {
				return RemoveImg();
			}

			@Override
			public ImageView handle(SetActiveSGPRMTRStudentServerPRMTRStudyGroupPRMTRMenuItem menuItem) {
				return new ImageView(new Image("/viewResources/set.png", 16, 16, true, true));
			}

			@Override
			public ImageView handle(SorcMTSWiMWuUPRMTRModuleWithoutUnitsPRMTRMarkPRMTRStringPRMTRMenuItem menuItem) {
				return new ImageView(new Image("/viewResources/set.png", 16, 16, true, true));
			}

			@Override
			public ImageView handle(SorcMTSWiUPRMTRUnitPRMTRThirdMarkPRMTRStringPRMTRMenuItem menuItem) {
				return new ImageView(new Image("/viewResources/set.png", 16, 16, true, true));
			}

			@Override
			public ImageView handle(ChangeCPPRMTRApprPRMTRFractionPRMTRMenuItem menuItem) {
				return new ImageView(new Image("/viewResources/change.png", 16, 16, true, true));
			}
			
		});
	}	
	private void addNotGeneratedItems(ContextMenu result, ViewRoot selected) {
		// Add items to menue if you have not generated service calls!!!
	}
	protected boolean getMultiSelectionFor(String parameterInBrowser){
		return false;
	}
	public int getPartsPerHour(String parameterInBrowser) {
		// divides 60 minutes into the returned number of parts
		return 59;
	}
	
}