package com.interview.mhe.presentation.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import com.mhe.R;

public class TransactionUtil {

    /**
     * Replace fragment with back stack is tag
     *
     * @param containerId    is view declare in xml, but not fragment view
     * @param fragment
     * @param isAddBackStack
     */
    public static void replaceFragment(FragmentManager fragmentManager, int containerId, Fragment fragment, boolean isAddBackStack) {
        replaceFragment(fragmentManager, containerId, fragment, isAddBackStack,
                android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * Replace fragment with back stack is tag
     * with custom animation
     *
     * @param containerId    is view declare in xml, but not fragment view
     * @param fragment
     * @param isAddBackStack
     * @param enter          res animation enter
     * @param exit           res animation exit
     * @param popEnter       res animation pop back stack enter
     * @param popExit        res animation pop back stack exit
     */
    public static void replaceFragment(FragmentManager fragmentManager, int containerId, Fragment fragment, boolean isAddBackStack,
                                       int enter, int exit, int popEnter, int popExit) {
        if ((0 == containerId) || (null == fragment)) {
            return;
        }
        // Auto get tag by fragment full path
        String tag = fragment.getClass().getName();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(enter, exit, popEnter, popExit);
        if (TextUtils.isEmpty(tag)) {
            // This case is very infrequent, because contentId is view but not fragment view (declare in xml)
            ft.replace(containerId, fragment);
        } else {
            ft.replace(containerId, fragment, tag);
        }

        if (isAddBackStack) {
            ft.addToBackStack(tag);
        }
        ft.commitAllowingStateLoss();
    }


    /**
     * Replace fragment with back stack is tag
     *
     * @param containerId    is view declare in xml, but not fragment view
     * @param fragment
     * @param isAddBackStack
     */
    public static void addFragmentDefaultAnimation(FragmentManager fragmentManager, int containerId, Fragment fragment, boolean isAddBackStack) {
        addFragment(fragmentManager, containerId, fragment, isAddBackStack,
                android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * Replace fragment with back stack is tag
     *
     * @param containerId    is view declare in xml, but not fragment view
     * @param fragment
     * @param isAddBackStack
     */
    public static void addFragment(FragmentManager fragmentManager, int containerId, Fragment fragment, boolean isAddBackStack) {
        addFragment(fragmentManager, containerId, fragment, isAddBackStack,
                R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
    }


    /**
     * Add fragment with back stack is tag
     * with custom animation
     *
     * @param containerId    is view declare in xml, but not fragment view
     * @param fragment
     * @param isAddBackStack
     * @param enter          res animation enter
     * @param exit           res animation exit
     * @param popEnter       res animation pop back stack enter
     * @param popExit        res animation pop back stack exit
     */
    public static void addFragment(FragmentManager fragmentManager, int containerId, Fragment fragment, boolean isAddBackStack,
                                   int enter, int exit, int popEnter, int popExit) {
        if ((0 == containerId) || (null == fragment)) {
            return;
        }
        // Auto get tag by fragment full path
        String tag = fragment.getClass().getName();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(enter, exit, popEnter, popExit);
        if (TextUtils.isEmpty(tag)) {
            // This case is very infrequent, because contentId is view but not fragment view (declare in xml)
            ft.add(containerId, fragment);
        } else {
            ft.add(containerId, fragment, tag);
        }

        if (isAddBackStack) {
            ft.addToBackStack(tag);
        }
        ft.commitAllowingStateLoss();
    }

}
