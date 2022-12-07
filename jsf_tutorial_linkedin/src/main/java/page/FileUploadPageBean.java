package page;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

@ViewScoped
@Named("fileUploadBean")
public class FileUploadPageBean implements Serializable {
    
   private Part uploadedFile;

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void uploadFile(){
        // We want to be able to log the file type, therefore we use anonmyous logger
        Logger.getAnonymousLogger().info("Uploaded file mimetype "+uploadedFile.getContentType());
    }
    
}
