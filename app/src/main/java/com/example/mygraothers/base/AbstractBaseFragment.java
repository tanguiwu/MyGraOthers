package com.example.mygraothers.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * abstract base Fragment
 * Created by tanguiwu
 */
public abstract class AbstractBaseFragment extends Fragment {
    protected boolean isFinishCreate = false;
    private long pageCreateTime = 0;
    protected long resumeTimes = 0;

    /**
     * get layout resource
     */
    protected abstract int getLayoutResId();

    /**
     *
     */
    protected abstract void initView(View v);

    /**
     *
     */
    protected abstract void initData();


    protected View mView;


    public AbstractBaseFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageCreateTime = System.currentTimeMillis() / 1000;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            if (getLayoutResId() == 0)
                return super.onCreateView(inflater, container, savedInstanceState);
            mView = inflater.inflate(getLayoutResId(), container, false);
            isFinishCreate = false;
            initView(mView);
            initData();
            isFinishCreate = true;
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    protected int getActionBarSize() {
        Activity activity = getActivity();
        if (activity == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        int[] textSizeAttr = new int[]{android.R.attr.actionBarSize};
        int indexOfAttrTextSize = 0;
        TypedArray a = activity.obtainStyledAttributes(typedValue.data, textSizeAttr);
        int actionBarSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();
        return actionBarSize;
    }
    protected int getScreenHeight() {
        return getActivity().findViewById(android.R.id.content).getHeight();
    }
    protected long getPageCreateTime() {
        return pageCreateTime;
    }

    @Override
    public void onResume() {
        super.onResume();
        resumeTimes ++;
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }








    protected int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    protected int getTab_id() {
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("tab_id")) {
            return bundle.getInt("tab_id");
        }

        return -1;
    }

    protected String getTab_name() {
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("tab_name")) {
            return bundle.getString("tab_name");
        }

        return null;
    }

    public Bundle getBundle() {
        return getArguments();
    }

    public void doFinishActivity() {
        Intent pIntent = getActivity().getIntent();
        getActivity().setResult(Activity.RESULT_OK, pIntent);
        getActivity().finish();
    }
}
