package viewClient;

import common.IconConstants;
import javafx.scene.image.Image;

public class IconManager {
	
	private IconManager(){}

	public static Image getImage(int iconInfo) {
		switch (iconInfo) {
//		case IconConstants.Error: return new Image("/viewResources/error.png");
		case IconConstants.Student: return new Image("/viewResources/student.png", 16, 16, true, true);
		case IconConstants.StudyGroup: return new Image("/viewResources/studyGroup.png", 16, 16, true, true);
		case IconConstants.StudyProgram: return new Image("/viewResources/studyProgram.png", 16, 16, true, true);
		case IconConstants.ModuleWithUnits: return new Image("/viewResources/moduleWithUnits.png", 16, 16, true, true);
		case IconConstants.ModuleWithoutUnits: return new Image("/viewResources/moduleWithoutUnits.png", 16, 16, true, true);
		case IconConstants.Unit: return new Image("/viewResources/unit.png", 16, 16, true, true);
		case IconConstants.ModuleGroup: return new Image("viewResources/moduleGroup.png", 16, 16, true, true);
		case IconConstants.Lst: return new Image("/viewResources/lst.png", 16, 16, true, true);
		case IconConstants.Create: return new Image("/viewResources/create.png", 16, 16, true, true);
		case IconConstants.Add: return new Image("/viewResources/add.png", 16, 16, true, true);
		case IconConstants.Set: return new Image("/viewResources/set.png", 16, 16, true, true);
		case IconConstants.Fetch: return new Image("/viewResources/fetch.png", 16, 16, true, true);
		default:
			return new Image("/viewResources/default.gif");
		}
	}
}
