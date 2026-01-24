import cytoscape from "cytoscape";


export const CYTOSCAPE_STYLES: cytoscape.StylesheetJson = [
     {
          selector: "node",
          style: {
            "background-color": "#4a90e2",
            label: "data(label)",
            color: "#fff",
            "text-valign": "center",
            "text-halign": "center",
            "font-size": "5px",
            shape: "round-rectangle",
            padding: "10px",
          },
        },
        {
          selector: "edge",
          style: {
            width: 2,
            "line-color": "#999",
            "target-arrow-color": "#999",
            "target-arrow-shape": "triangle",
            "curve-style": "bezier",
          },
        },
        {
      selector: "edge.circular",
      style: {
        "line-color": "red",
        "target-arrow-color": "red",
        "width": 3
      }
    }
]