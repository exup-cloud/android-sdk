package com.bmtc.sdk.contract.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bmtc.sdk.contract.R;


/**
 * Created by rygelouv on 9/21/17.
 * <p>
 * AndroidLoadingButton
 * Copyright 2017 Rygelouv.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

public class LoadingButton extends LinearLayout
{
    private static final int TEXT_DIFF = 14;
    View mRootView;
    private int textColor;
    private String text;
    private int backgroundColor;
    private Drawable background;
    private float textSize;
    private int progressColor;
    private TextView mTextButton;
    private ProgressBar mProgressBar;

    public LoadingButton(Context context)
    {
        super(context);
        init(context);
    }

    public LoadingButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        getAttributes(context, attrs);
        init(context);
    }

    public LoadingButton(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        getAttributes(context, attrs);
        init(context);
    }

    private void getAttributes(Context context, AttributeSet attrs)
    {
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LoadingButton, 0, 0);
        this.text = ta.getString(R.styleable.LoadingButton_lbText);
        this.textColor = ta.getColor(R.styleable.LoadingButton_lbTextColor,
                getResources().getColor(android.R.color.black));
        this.textSize = (int) ta.getDimension(R.styleable.LoadingButton_lbTextSize, getDimension(R.dimen.text_size_tab));
        this.backgroundColor = ta.getColor(R.styleable.LoadingButton_lbBackgroundColor,
                getResources().getColor(android.R.color.background_dark));
        this.background = ta.getDrawable(R.styleable.LoadingButton_lbBackground);
        this.progressColor = ta.getColor(R.styleable.LoadingButton_lbProgressColor,
                getResources().getColor(android.R.color.black));

        ta.recycle();
    }

    private float getDimension(@DimenRes int resId) {
        return getResources().getDimension(resId);
    }

    private void init(Context context)
    {
        this.mRootView = inflate(context, R.layout.sl_loading_button_layout, this);
        this.mTextButton = mRootView.findViewById(R.id.button);
        this.mProgressBar = mRootView.findViewById(R.id.progress);

        if (!TextUtils.isEmpty(text))
            mTextButton.setText(text);

        if (textColor != 0)
            mTextButton.setTextColor(textColor);

        if (textSize != 0)
            mTextButton.setTextSize(18);

        if (backgroundColor != 0)
            this.mRootView.setBackgroundColor(backgroundColor);

        if (background != null)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                this.mRootView.setBackground(background);
            }

        if (progressColor != 0)
            this.mProgressBar.getIndeterminateDrawable().setColorFilter(progressColor,
                    PorterDuff.Mode.MULTIPLY);
    }

    public void startLoading(String loadingText)
    {
        this.setEnabled(false);
        this.mProgressBar.setVisibility(VISIBLE);
        this.mTextButton.setText(loadingText.toUpperCase());
    }

    public void stopLoading(String loadingDoneText)
    {
        this.setEnabled(true);
        this.mProgressBar.setVisibility(GONE);
        this.mTextButton.setText(loadingDoneText.toUpperCase());
    }

    public int getTextColor()
    {
        return textColor;
    }

    public void setTextColor(int textColor)
    {
        this.textColor = textColor;
        mTextButton.setTextColor(textColor);
    }

    public String getText()
    {
        return text;
    }

    public void setText(@NonNull String text)
    {
        this.text = text;
        mTextButton.setText(text);
    }

    public int getCustomBackgroundColor()
    {
        return backgroundColor;
    }

    public void setCustomBackgroundColor(int backgroundColor)
    {
        this.backgroundColor = backgroundColor;
        mRootView.setBackgroundColor(backgroundColor);
    }

    public Drawable getCustomBackground()
    {
        return background;
    }

    public void setCustomBackground(@NonNull Drawable background)
    {
        this.background = background;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mRootView.setBackground(background);
        }
    }

    public float getTextSize()
    {
        return textSize;
    }

    public void setTextSize(float textSize)
    {
        this.textSize = textSize;
        mTextButton.setTextSize(textSize);
    }

    public int getProgressColor()
    {
        return progressColor;
    }

    public void setProgressColor(int progressColor)
    {
        this.progressColor = progressColor;
        mProgressBar.getIndeterminateDrawable().setColorFilter(progressColor,
                android.graphics.PorterDuff.Mode.MULTIPLY);
    }
}
