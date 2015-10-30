/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sola.android.architecture.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sola.android.architecture.R;
import com.sola.android.architecture.view.interactor.IRecycleListItem;

/**
 * Class that represents a user in the presentation layer.
 */
public class UserModel implements IRecycleListItem {

    private final int userId;

    public UserModel(int userId) {
        this.userId = userId;
    }

    private String coverUrl;
    private String fullName;
    private String email;
    private String description;
    private int followers;

    public int getUserId() {
        return userId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("***** User Model Details *****\n");
        stringBuilder.append("id=" + this.getUserId() + "\n");
        stringBuilder.append("cover url=" + this.getCoverUrl() + "\n");
        stringBuilder.append("fullname=" + this.getFullName() + "\n");
        stringBuilder.append("email=" + this.getEmail() + "\n");
        stringBuilder.append("description=" + this.getDescription() + "\n");
        stringBuilder.append("followers=" + this.getFollowers() + "\n");
        stringBuilder.append("*******************************");

        return stringBuilder.toString();
    }

    @Override
    public View getView(Context context, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_test_item_dto,
                parent, false);
        return v;
    }

    @Override
    public RecyclerView.ViewHolder getHolder(Context context, ViewGroup parent) {
        return new ViewHolder(getView(context, parent));
    }

    @Override
    public void refreshView(Context context, RecyclerView.ViewHolder holder) {
        ((ViewHolder) holder).id_text_test.setText(fullName);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_text_test;
        ImageView id_image_item_shown;

        public ViewHolder(
                View v) {
            super(v);
            id_text_test = (TextView) v.findViewById(R.id.id_text_test);
        }

    }
}
