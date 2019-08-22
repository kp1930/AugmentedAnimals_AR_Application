package com.theblackdiamonds.augmentedanimals;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity {

    ArFragment arFragment;
    ModelRenderable bearRenderable, catRenderable, cowRenderable, dogRenderable, elephantRenderable,
            ferretRenderable, hippopotamusRenderable, horseRenderable, koalaBearRenderable,
            lionRenderable, reindeerRenderable, wolverineRenderable;
    ImageView bear, cat, cow, dog, elephant, ferret,
            hippopotamus, horse, koalaBear, lion, reindeer, wolverine;
    View[] arrayView;
    int selected = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);

        bear = findViewById(R.id.bear);
        cat = findViewById(R.id.cat);
        cow = findViewById(R.id.cow);
        dog = findViewById(R.id.dog);
        elephant = findViewById(R.id.elephant);
        ferret = findViewById(R.id.ferret);
        hippopotamus = findViewById(R.id.hippopotamus);
        horse = findViewById(R.id.horse);
        koalaBear = findViewById(R.id.koala_bear);
        lion = findViewById(R.id.lion);
        reindeer = findViewById(R.id.reindeer);
        wolverine = findViewById(R.id.wolverine);

        setArrayView();
        setOnClickListener();
        setUpModel();

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            Anchor anchor = hitResult.createAnchor();
            AnchorNode anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());

            createModel(anchorNode, selected);
        });
    }

    private void setUpModel() {

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load bear", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load cat", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load cow", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load dog", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.elephant)
                .build().thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load elephant", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load ferret", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippopotamusRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load hippopotamus", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load horse", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.koala_bear)
                .build().thenAccept(renderable -> koalaBearRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load koala bear", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load lion", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.reindeer)
                .build().thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load reindeer", Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(MainActivity.this, R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Unable to load wolverine", Toast.LENGTH_LONG).show();
                    return null;
                });
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();

            addName(anchorNode, bear, "Bear");
        }
        if (selected == 2) {
            TransformableNode cat = new TransformableNode(arFragment.getTransformationSystem());
            cat.setParent(anchorNode);
            cat.setRenderable(catRenderable);
            cat.select();

            addName(anchorNode, cat, "Cat");
        }
        if (selected == 3) {
            TransformableNode cow = new TransformableNode(arFragment.getTransformationSystem());
            cow.setParent(anchorNode);
            cow.setRenderable(cowRenderable);
            cow.select();

            addName(anchorNode, cow, "Cow");
        }
        if (selected == 4) {
            TransformableNode dog = new TransformableNode(arFragment.getTransformationSystem());
            dog.setParent(anchorNode);
            dog.setRenderable(dogRenderable);
            dog.select();

            addName(anchorNode, dog, "Dog");
        }
        if (selected == 5) {
            TransformableNode elephant = new TransformableNode(arFragment.getTransformationSystem());
            elephant.setParent(anchorNode);
            elephant.setRenderable(elephantRenderable);
            elephant.select();

            addName(anchorNode, elephant, "Elephant");
        }
        if (selected == 6) {
            TransformableNode ferret = new TransformableNode(arFragment.getTransformationSystem());
            ferret.setParent(anchorNode);
            ferret.setRenderable(ferretRenderable);
            ferret.select();

            addName(anchorNode, ferret, "Ferret");
        }
        if (selected == 7) {
            TransformableNode hippopotamus = new TransformableNode(arFragment.getTransformationSystem());
            hippopotamus.setParent(anchorNode);
            hippopotamus.setRenderable(hippopotamusRenderable);
            hippopotamus.select();

            addName(anchorNode, hippopotamus, "Hippopotamus");
        }
        if (selected == 8) {
            TransformableNode horse = new TransformableNode(arFragment.getTransformationSystem());
            horse.setParent(anchorNode);
            horse.setRenderable(horseRenderable);
            horse.select();

            addName(anchorNode, horse, "Horse");
        }
        if (selected == 9) {
            TransformableNode koalaBear = new TransformableNode(arFragment.getTransformationSystem());
            koalaBear.setParent(anchorNode);
            koalaBear.setRenderable(koalaBearRenderable);
            koalaBear.select();

            addName(anchorNode, koalaBear, "Koala Bear");
        }
        if (selected == 10) {
            TransformableNode lion = new TransformableNode(arFragment.getTransformationSystem());
            lion.setParent(anchorNode);
            lion.setRenderable(lionRenderable);
            lion.select();

            addName(anchorNode, lion, "Lion");
        }
        if (selected == 11) {
            TransformableNode reindeer = new TransformableNode(arFragment.getTransformationSystem());
            reindeer.setParent(anchorNode);
            reindeer.setRenderable(reindeerRenderable);
            reindeer.select();

            addName(anchorNode, reindeer, "Reindeer");
        }
        if (selected == 12) {
            TransformableNode wolverine = new TransformableNode(arFragment.getTransformationSystem());
            wolverine.setParent(anchorNode);
            wolverine.setRenderable(wolverineRenderable);
            wolverine.select();

            addName(anchorNode, wolverine, "Wolverine");
        }
    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {

        ViewRenderable.builder()
                .setView(MainActivity.this, R.layout.name_animal)
                .build()
                .thenAccept(viewRenderable -> {
                    TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y + 0.5f, 0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();

                    TextView textName = (TextView) viewRenderable.getView();
                    textName.setText(name);
                    textName.setOnClickListener(view -> anchorNode.setParent(null));
                });
    }

    private void setOnClickListener() {
        for (View view : arrayView) {
            view.setOnClickListener(view1 -> {
                if (view1.getId() == R.id.bear) {
                    selected = 1;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.cat) {
                    selected = 2;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.cow) {
                    selected = 3;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.dog) {
                    selected = 4;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.elephant) {
                    selected = 5;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.ferret) {
                    selected = 6;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.hippopotamus) {
                    selected = 7;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.horse) {
                    selected = 8;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.koala_bear) {
                    selected = 9;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.lion) {
                    selected = 10;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.reindeer) {
                    selected = 11;
                    setBackground(view1.getId());
                } else if (view1.getId() == R.id.wolverine) {
                    selected = 12;
                    setBackground(view1.getId());
                }
            });
        }
    }

    private void setBackground(int id) {
        for (View view : arrayView) {
            if (view.getId() == id) {
                view.setBackgroundColor(Color.parseColor("#80333639"));
            } else {
                view.setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }

    private void setArrayView() {
        arrayView = new View[]{
                bear, cat, cow, dog, elephant, ferret,
                hippopotamus, horse, koalaBear, lion, reindeer, wolverine
        };
    }
}