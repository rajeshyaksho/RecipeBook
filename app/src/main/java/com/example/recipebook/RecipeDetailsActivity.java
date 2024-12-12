package com.example.recipebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class RecipeDetailsActivity extends AppCompatActivity {

    EditText titleEditText,contentEditText;
    ImageButton saveRecipeBtn;
    TextView pageTitleTextView;
    String title,content,docId;
    boolean isEditMode = false;
    ImageButton deleteRecipeTextViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        titleEditText = findViewById(R.id.recipe_title_text);
        contentEditText = findViewById(R.id.recipe_content_text);
        saveRecipeBtn = findViewById(R.id.save_recipe_btn);
        pageTitleTextView = findViewById(R.id.page_title);
        deleteRecipeTextViewBtn  = findViewById(R.id.delete_recipe_btn);

        //receive data
        title = getIntent().getStringExtra("title");
        content= getIntent().getStringExtra("content");
        docId = getIntent().getStringExtra("docId");

        if(docId!=null && !docId.isEmpty()){
            isEditMode = true;
        }

        titleEditText.setText(title);
        contentEditText.setText(content);
        if(isEditMode){
            pageTitleTextView.setText("Edit your Recipe");
            deleteRecipeTextViewBtn.setVisibility(View.VISIBLE);
        }

        saveRecipeBtn.setOnClickListener( (v)-> saveRecipe());
        deleteRecipeTextViewBtn.setOnClickListener((v)-> deleteRecipeFromFirebase() );
    }

    void saveRecipe(){
        String recipeTitle = titleEditText.getText().toString();
        String recipeContent = contentEditText.getText().toString();
        if(recipeTitle==null || recipeTitle.isEmpty() ){
            titleEditText.setError("Title is required");
            return;
        }
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeTitle);
        recipe.setContent(recipeContent);
        recipe.setTimestamp(Timestamp.now());

        saveRecipeToFirebase(recipe);

    }

    void saveRecipeToFirebase(Recipe recipe){
        DocumentReference documentReference;
        if(isEditMode){
            //updated the recipe
            documentReference = Utility.getCollectionReferenceForRecipes().document(docId);
        }else{
            //created new recipe
            documentReference = Utility.getCollectionReferenceForRecipes().document();
        }
        documentReference.set(recipe).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //recipe is added
                    Utility.showToast(RecipeDetailsActivity.this,"Note added successfully");
                    finish();
                }else{
                    Utility.showToast(RecipeDetailsActivity.this,"Failed while adding note");
                }
            }
        });

    }
    void deleteRecipeFromFirebase(){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForRecipes().document(docId);
        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //recipe is deleted
                    Utility.showToast(RecipeDetailsActivity.this,"Recipe deleted successfully");
                    finish();
                }else{
                    Utility.showToast(RecipeDetailsActivity.this,"Failed while deleting recipe");
                }
            }
        });
    }

}