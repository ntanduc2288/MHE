package com.interview.mhe.presentation.ui.userList;

import com.interview.mhe.domain.DataManagerImpl;
import com.interview.mhe.domain.DataRepository;
import com.interview.mhe.presentation.uiObjects.UserObject;
import com.interview.mhe.presentation.utils.RxUtil;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class UserListPresenterImpl implements UserListPresenter.Presenter {
    private UserListPresenter.View view;
    DataRepository dataRepository;
    PublishSubject<String> publishSubject = PublishSubject.create();
    CompositeDisposable compositeDisposable;

    public UserListPresenterImpl(UserListPresenter.View view) {
        this.view = view;
        dataRepository = new DataManagerImpl();
        compositeDisposable = new CompositeDisposable();
        initLoadingUserInfo();
    }

    /**
     * Listener trigger event to load data from server and display on view
     */
    private void initLoadingUserInfo(){
        Disposable disposable = publishSubject
                .flatMap(emptyData -> dataRepository.getUsers())
                .compose(RxUtil.applySchedulersRx2())
                .subscribe(userObjects -> updateUserList(userObjects),
                        throwable -> handleProfileError(throwable));

        compositeDisposable.add(disposable);
    }

    /**
     * Bind users to UI
     * @param userObjects
     */
    private void updateUserList(ArrayList<UserObject> userObjects){
        if (view != null) {
            view.hideLoading();

            //update user list view
            view.bindUsersToUI(userObjects);
        }
    }

    /**
     * Show error message in unexpected case (Should show friendly message instead)
     * @param throwable
     */
    private void handleProfileError(Throwable throwable){
        if(view != null){
            view.hideLoading();
            view.showMessage(throwable.getMessage());
        }
        initLoadingUserInfo();
    }

    @Override
    public void triggerLoadUserDatas() {
        if (view != null) {
            view.showLoading();
            publishSubject.onNext("");
        }
    }

    @Override
    public void release() {
        if (compositeDisposable == null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
            compositeDisposable.dispose();
        }
    }
}
