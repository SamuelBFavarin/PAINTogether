package PAINTogether.shared;

/**
 * Created by Lucas Baragatti on 15/12/2016.
 */
public interface ServerCallback {

    void onError(Object response);

    void onSuccess(Object response);

}
