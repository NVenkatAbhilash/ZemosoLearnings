import React from "react";
import MainView from "../components/templates/MainView/MainView";
import AboutMe from "../components/templates/AboutMe/AboutMe";
import Gallery from "../components/templates/Gallery/Gallery";
import ContactMe from "../components/templates/ContactMe/ContactMe";

const Primary = (props) => {
  return (
    <div>
      <MainView />
      <AboutMe />
      <Gallery />
      <ContactMe />
      
    </div>
  );
};

export default Primary;
