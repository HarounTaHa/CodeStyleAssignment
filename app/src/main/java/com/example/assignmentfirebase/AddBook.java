package com.example.assignmentfirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddBook extends AppCompatActivity {
    // comment.firestore
    private FirebaseFirestore firestore;
    private   EditText edDescription;
    private EditText edAuthor;
    private  EditText edName;
    private  String nameBook;
    private  EditText ednumOfPages;
    private  EditText edyearPublishing;
    private  String authorName;
    private  String drscriptionBook;
    private   float numOfpages;
    private  float yearOfPublishing;
    @Override
     protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Button addNewBook = findViewById(R.id.add_new_book);
        edName = findViewById(R.id.name_book);
        edAuthor = findViewById(R.id.author_book);
        edDescription = findViewById(R.id.description_book);
        ednumOfPages = findViewById(R.id.num_pages);
        edyearPublishing = findViewById(R.id.year_publishing);
//        ----------------------------------------------
          firestore = FirebaseFirestore.getInstance();
//        ----------------------------------------------
        addNewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (!edName.getText().toString().isEmpty()
                        && !edAuthor.getText().toString().isEmpty()
                        && !edDescription.getText().toString().isEmpty()
                        && !ednumOfPages.getText().toString().isEmpty()
                        && !edyearPublishing.getText().toString().isEmpty()) {
                    nameBook = edName.getText().toString();
                    authorName = edAuthor.getText().toString();
                    numOfpages = Float.parseFloat(ednumOfPages.getText().toString());
                    yearOfPublishing = Float.parseFloat(edyearPublishing.getText().toString());
                    drscriptionBook = edDescription.getText().toString();
//                    -----------------add to FireBase---------------------
                    CollectionReference collectionReference = firestore.collection("books");
                    Book newBook = addBook(nameBook, authorName, drscriptionBook, numOfpages, yearOfPublishing);
                    Task<DocumentReference> t =collectionReference.add(newBook);
                    t.addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getApplicationContext(),"تمت الاضافة بنجاج",Toast.LENGTH_LONG).show();
                        }
                    });
                    t.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"حدث خطأ في الاضافة",Toast.LENGTH_LONG).show();
                        }

                    });

                } else {
                    Toast.makeText(getApplicationContext(),"Empty field",Toast.LENGTH_LONG).show();
                }
            }

        });
    }
//    -----------------------------------------------------------------------------------
     public Book addBook(String nameBook,String authorName,String drscriptionBook,float numOfpages,float yearOfPublishing){
     Book b = new Book(nameBook,authorName,drscriptionBook,numOfpages,yearOfPublishing);
         return b;
    }
}

