package com.example.alpha2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FBreff {

    public static FirebaseDatabase FBDB = FirebaseDatabase.getInstance();
    public static DatabaseReference refUsers = FBDB.getReference("Users");
    public static FirebaseStorage FBST = FirebaseStorage.getInstance();
    public static StorageReference refStor = FBST.getReference();
    public static StorageReference refImages = refStor.child("Images");
}
