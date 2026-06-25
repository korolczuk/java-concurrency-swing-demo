# Java Concurrency & Swing Multithreading Demo

An educational desktop application built with Java Swing that demonstrates the practical application of multithreading and concurrency concepts in graphical user interfaces (GUIs). 

The primary goal of this project is to showcase how to execute long-running background tasks (such as timed rendering and animations) without freezing or blocking the main User Interface thread.

## 🚀 Key Features & Concurrency Concepts

* **Non-Blocking UI:** The application remains completely responsive (allowing window resizing, moving, and clicking other buttons) while intensive drawing tasks operate in the background.
* **Thread Pool Management (`ExecutorService`):** Utilizes `Executors.newCachedThreadPool()` to dynamically manage, reuse, and allocate background threads for concrete tasks.
* **Event Dispatch Thread (EDT) Synchronization:** Adheres to Swing's single-thread rule. Background threads handle heavy processing and delays (`Thread.sleep`), but UI components are updated safely via `SwingUtilities.invokeLater()`.

## 🛠️ How It Works (Demonstration)

The interface features a control panel that triggers independent asynchronous actions on a drawing canvas:
1. **Point Generator:** Spawns 10 random points on the canvas, introducing a deliberate 1-second delay (`Thread.sleep(1000)`) between each spawn.
2. **Line Renderer:** Draws 5 independent lines sequentially with 1-second intervals.
3. **Background Animator:** Smoothly transitions the canvas background color over 100 iterations with precise 20ms intervals.

*All these processes can run concurrently. You can trigger the background animation and immediately start drawing points; both tasks execute in parallel without any interface stuttering.*

## 💻 Tech Stack

* **Language:** Java
* **GUI Library:** Java Swing / AWT
* **Concurrency Tools:** `ExecutorService`, `CachedThreadPool`, `Future`, `SwingUtilities.invokeLater`

## 🔧 How to Run

1. Clone the repository:
   ```bash
   git clone [https://github.com/korolczuk/java-concurrency-swing-demo.git](https://github.com/korolczuk/java-concurrency-swing-demo.git)
