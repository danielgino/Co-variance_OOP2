#  Prototype-Based Object Classification – OOP Assignment 2
##  Question 1 – Prototype Theory by Rosch (1975)

This project implements a model inspired by **Eleanor Rosch's Prototype Theory**, using object-oriented programming. It evaluates how well real-world objects match an **ideal prototype** within a given category based on a set of weighted features.

---

##  Theoretical Background

According to Rosch (1975), categories like "birds" or "furniture" are structured around **central prototypes**, not rigid definitions. Some members are more **typical** than others.

### Example:

| Category: Birds        | Typicality Score |
|------------------------|------------------|
| Sparrow (דרור)         | 1.18             |
| Penguin (פינגווין)     | 4.53             |
| Bat (עטלף)             | 6.15             |

The lower the score, the more typical the item is perceived.

---

##  System Overview

The system loads:
- ✅ **Features per category** with weights and ideal values (`features.csv`)
- ✅ **Objects** with actual feature values (`objects.csv`)
- ✅ It calculates a **closeness score** between each object and its category’s prototype.

---

##  Object-Oriented Design

### Key Classes:
| Class              | Description                                               |
|--------------------|-----------------------------------------------------------|
| `PrototypeObject`  | Represents an object with a name, category, and features. |
| `Feature`          | Encapsulates name, value, and weight of a feature.        |
| `FeatureLoader`    | Loads features from CSV per category.                     |
| `ObjectLoader`     | Loads real objects and their feature values.              |

---
# Levels:
```
========= סקאלת טיפוסיות =========
1 = טיפוסי מאוד
2 = טיפוסי
3 = די טיפוסי
4 = בינוני
5 = לא כל כך טיפוסי
6 = כמעט לא טיפוסי
7 = לא טיפוסי בכלל
=== קטגוריה: ציפורים ===
דרור => ציון טיפוסיות: 1.20 (טיפוסי מאוד)
פינגווין => ציון טיפוסיות: 4.53 (בינוני)
עטלף => ציון טיפוסיות: 6.15 (כמעט לא טיפוסי)

=== קטגוריה: רהיטים ===
טלפון => ציון טיפוסיות: 6.68 (לא טיפוסי בכלל)
מראה => ציון טיפוסיות: 4.39 (בינוני)
כיסא => ציון טיפוסיות: 1.04 (טיפוסי מאוד)
```

# Example Run 

```

========= סקאלת טיפוסיות (1 = טיפוסי מאוד, 7 = לא טיפוסי בכלל) =========
ציון | פירוש
---------------
1 =טיפוסי מאוד
2 = טיפוסי
 3= די טיפוסי
4 = בינוני
5 = לא כל כך טיפוסי
 6 = כמעט לא טיפוסי
7 = לא טיפוסי בכלל
==============================================================

=== קטגוריה: ציפורים ===
דרור => ציון טיפוסיות: 1.04 (טיפוסי מאוד)
ינשוף => ציון טיפוסיות: 2.69 (די טיפוסי)
עטלף => ציון טיפוסיות: 5.88 (כמעט לא טיפוסי)
פינגווין => ציון טיפוסיות: 4.93 (לא כל כך טיפוסי)
=== קטגוריה: רהיטים ===
כסא => ציון טיפוסיות: 1.24 (טיפוסי מאוד)
שולחן => ציון טיפוסיות: 1.24 (טיפוסי מאוד)
מראה => ציון טיפוסיות: 6.11 (כמעט לא טיפוסי)
טלפון => ציון טיפוסיות: 7.00 (לא טיפוסי בכלל)
=== קטגוריה: משקאות ===
מים => ציון טיפוסיות: 1.02 (טיפוסי מאוד)
קולה => ציון טיפוסיות: 1.00 (טיפוסי מאוד)
שמן => ציון טיפוסיות: 5.41 (לא כל כך טיפוסי)
חומץ => ציון טיפוסיות: 5.41 (לא כל כך טיפוסי)

```

