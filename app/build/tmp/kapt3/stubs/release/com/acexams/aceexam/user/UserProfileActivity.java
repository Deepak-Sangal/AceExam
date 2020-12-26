package com.acexams.aceexam.user;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\r\u0010?\u001a\u0004\u0018\u00010@\u00a2\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010\u0019J\u0018\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HJ\u0012\u0010I\u001a\u0004\u0018\u00010\t2\b\u0010C\u001a\u0004\u0018\u00010\u0019J\u0010\u0010J\u001a\u00020@2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010K\u001a\u00020LJ\"\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010QH\u0014J\u0012\u0010R\u001a\u00020L2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0012\u0010U\u001a\u00020L2\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J-\u0010X\u001a\u00020L2\u0006\u0010N\u001a\u00020\u00052\u000e\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0Z2\u0006\u0010[\u001a\u00020\\H\u0016\u00a2\u0006\u0002\u0010]J\b\u0010^\u001a\u00020LH\u0002J\u0010\u0010_\u001a\u00020L2\u0006\u0010`\u001a\u00020FH\u0002J\u0006\u0010a\u001a\u00020LJ\u0006\u0010b\u001a\u00020LJ\u0006\u0010c\u001a\u00020LR\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010\'\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001c\u0010-\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001a\u00100\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001c\u00103\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001a\u00106\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001a\u00109\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001a\u0010<\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000e\u00a8\u0006d"}, d2 = {"Lcom/acexams/aceexam/user/UserProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "RECORD_REQUEST_CODE", "", "getRECORD_REQUEST_CODE", "()I", "TAG", "", "email", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "id", "getId", "setId", "imageUriSign", "Landroid/net/Uri;", "getImageUriSign", "()Landroid/net/Uri;", "setImageUriSign", "(Landroid/net/Uri;)V", "img_salon", "Landroid/widget/ImageView;", "getImg_salon", "()Landroid/widget/ImageView;", "setImg_salon", "(Landroid/widget/ImageView;)V", "mFilePathSign", "getMFilePathSign", "setMFilePathSign", "mobile", "getMobile", "setMobile", "name", "getName", "setName", "picname", "getPicname", "setPicname", "profile_image", "getProfile_image", "setProfile_image", "profileimageString", "getProfileimageString", "setProfileimageString", "removeimage_value", "getRemoveimage_value", "setRemoveimage_value", "sendemail", "getSendemail", "setSendemail", "token", "getToken", "setToken", "checkpermission", "", "()Ljava/lang/Boolean;", "getAbsolutePath", "uri", "getImageUri", "inContext", "Landroid/content/Context;", "inImage", "Landroid/graphics/Bitmap;", "getPath", "isValid", "makeRequest", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "profile", "selectImage", "context", "setupPermissions", "update", "validation", "app_release"})
public final class UserProfileActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.Nullable()
    private java.io.File file;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String sendemail = "";
    @org.jetbrains.annotations.NotNull()
    public java.lang.String token;
    private final int RECORD_REQUEST_CODE = 101;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri imageUriSign;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mFilePathSign = "";
    @org.jetbrains.annotations.Nullable()
    private android.widget.ImageView img_salon;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profile_image = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String picname;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String profileimageString;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String id;
    private final java.lang.String TAG = "PermissionDemo";
    @org.jetbrains.annotations.NotNull()
    public java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String email;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String mobile;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String removeimage_value = "0";
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.Nullable()
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSendemail() {
        return null;
    }
    
    public final void setSendemail(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getRECORD_REQUEST_CODE() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getImageUriSign() {
        return null;
    }
    
    public final void setImageUriSign(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMFilePathSign() {
        return null;
    }
    
    public final void setMFilePathSign(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getImg_salon() {
        return null;
    }
    
    public final void setImg_salon(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfile_image() {
        return null;
    }
    
    public final void setProfile_image(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPicname() {
        return null;
    }
    
    public final void setPicname(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProfileimageString() {
        return null;
    }
    
    public final void setProfileimageString(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMobile() {
        return null;
    }
    
    public final void setMobile(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRemoveimage_value() {
        return null;
    }
    
    public final void setRemoveimage_value(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void selectImage(android.content.Context context) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getImageUri(@org.jetbrains.annotations.NotNull()
    android.content.Context inContext, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap inImage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAbsolutePath(@org.jetbrains.annotations.Nullable()
    android.net.Uri uri) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean checkpermission() {
        return null;
    }
    
    public final void setupPermissions() {
    }
    
    public final void makeRequest() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    public final void validation() {
    }
    
    public final boolean isValid(@org.jetbrains.annotations.Nullable()
    java.lang.String email) {
        return false;
    }
    
    public final void update() {
    }
    
    private final void profile() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPath(@org.jetbrains.annotations.Nullable()
    android.net.Uri uri) {
        return null;
    }
    
    public UserProfileActivity() {
        super();
    }
}