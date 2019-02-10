public class ClassTested {


    public interface Collaborator {
        void documentAdded(String title);
        void documentRemoved(String title);

    }

    Collaborator listener;


    public void setListener(Collaborator listener) {
        this.listener = listener;
    }

    public void addDocument(String title) {
        listener.documentAdded(title);
    }

    public void removeDocument(String title) {
        listener.documentRemoved(title);
    }

}
