package com.example.assignmentfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowAllBooks extends AppCompatActivity {
    RecyclerView rv;
    FirebaseFirestore dbReference;
    List<Book> listOfBooks;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_books);
        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));


        listOfBooks=new ArrayList<>();
      dbReference= FirebaseFirestore.getInstance();

        CollectionReference bookReference= dbReference.collection("books");
         Task<QuerySnapshot> t=bookReference.get();
         t.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
             @Override
             public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
           Iterator<QueryDocumentSnapshot> iter = queryDocumentSnapshots.iterator();
            while (iter.hasNext()){
               Book b = iter.next().toObject(Book.class);
               listOfBooks.add(b);
            }
                 adapter= new MyAdapter(getApplicationContext(),listOfBooks);
                 rv.setAdapter(adapter);
             }
         });

      /*     // dbReference = FirebaseDatabase.getInstance().getReference().child("books");

        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                   Book itemBook = dataSnapshot.getValue(Book.class);
                    listOfBooks.add(itemBook);
                }
                adapter= new MyAdapter(getApplicationContext(),listOfBooks);
                rv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ShowAllBooks.this, "opsss..failure operation ", Toast.LENGTH_SHORT).show();
            }
        });

*/

    }
}
