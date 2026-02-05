# 🔗 Dependency Tracker

Dependency Tracker is an open-source library designed to **analyze, visualize, and continuously track dependencies** between software components. It provides a **graph-based interactive view** of dependencies while ensuring **high reliability through automatic startup and fault recovery**, even when runtime errors occur.

This library is built to be **resilient, developer-friendly, and production-ready**, making it suitable for real-world systems and open-source adoption.

---

## 🚀 Core Capability: Automatic Startup & Fault Recovery

One of the key strengths of Dependency Tracker is its **self-healing behavior**.

- Automatically **starts and re-initializes** during:
  - Runtime errors
  - Partial application failures
  - Dependency resolution issues
- Restores the dependency graph **without manual intervention**
- Ensures uninterrupted dependency tracking
- Suitable for long-running tools and monitoring dashboards

This makes Dependency Tracker reliable even when the host application encounters unexpected failures.

---

## ✨ Features

- 📊 **Interactive Dependency Visualization**
  - Components represented as nodes
  - Dependencies represented as directed edges

- ❌ **Missing Dependency Detection**
  - Automatically identifies unresolved or missing dependencies
  - Missing elements are visually highlighted

- 🔁 **Circular Dependency Detection**
  - Detects cyclic dependency chains
  - Helps prevent architectural and runtime issues

- 🔍 **Relationship Analysis**
  - Clearly shows:
    - Dependencies
    - Reverse dependencies (used by)
  - Interactive highlighting on hover and selection

- 🎨 **Customizable Graph Styling**
  - Modern UI with animations
  - Easy theme and layout customization

---

## 🛠️ Technology Stack

- **Language:** JavaScript / TypeScript  
- **Graph Engine:** Cytoscape.js  
- **Architecture:** Modular, scalable, and library-oriented  
- **UI Support:** Tailwind CSS compatible

---

## 📐 Design Principles

- Fault-tolerant by default  
- Automatic recovery without manual restart  
- Minimal configuration  
- Scalable for large dependency graphs  
- Designed for open-source extensibility  

---

## ⚙️ How It Works

1. Dependency data is provided in structured JSON format.

2. Each component is converted into a graph node.

3. Dependency relationships are mapped as directed edges.

4. Missing and circular dependencies are automatically detected.

5. If an error occurs:

    - The system safely reinitializes

    - The dependency graph is restored automatically

    - Cytoscape renders the interactive dependency graph.
```text
[
  {
    "name": "com.example.sample.controller.SampleController",
    "dependencies": [
      "com.example.sample.service.AccountService"
    ]
  }
]
```
- ## 📈 Use Cases

  - Dependency analysis for large codebases

  - Architectural validation

  - Understanding legacy systems

  - Developer onboarding

  -  Debugging complex dependency chains

  -  Continuous dependency monitoring tools

- ## 🌍 Open-Source Goals

  -  Easy integration into existing projects

  - Clear and stable public APIs

  - Reliable behavior under failures

  - Community-driven enhancements

- ## 🧩 Roadmap

  - Automatic dependency extraction from Java / Spring Boot projects

  - Graph export (PNG, SVG, JSON)

  - Plugin system

  - CI/CD integration

  - Dependency health and risk scoring

- ## 🤝 Contributing

Contributions are welcome.
Please submit issues, feature requests, or pull requests to help improve the library.

- ## 📜 License

This project is released under the MIT License.
