import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import { Button, Grid } from "@material-ui/core";

const students = [
  {
    name: "Sam",
    interests: ["Maths", "Physics"],
    age: 15,
  },
  {
    name: "Ram",
    interests: ["Chemistry", "Physics"],
    age: 16,
  },
  {
    name: "Abhi",
    interests: ["Maths", "English"],
    age: 14,
  },
  {
    name: "Venkat",
    interests: ["Biology", "Physics"],
    age: 17,
  },
];
const useStyles = makeStyles({
  root: {
    padding: "40px",
  },
  button:{
    backgroundColor:"yellow",
    
  },
  active:{
    backgroundColor:"red",
  }
});


const LearnFilter = (props) => {
  const classes = useStyles();

  //const theStudents = students;

  const [theStudents, setStudents] = useState({studentDetails : students});

  const [theButtons, setButtons] = useState({
    buttons:[
      {
        id:6,
        name: "sortByAge",
        class: "",
        onClickFun : ()=>{
          const temp = theStudents.studentDetails;
          temp.splice(1,1);
          setStudents({
            studentDetails: temp
          })
          const tempB = theButtons.buttons
          tempB[0].class="active";
          setButtons({
            buttons : tempB,
          })
          console.log(theStudents);
        }
      },
      {
        id:4,
        name: "sortByName",
        onClickFun : (event,...other)=>{
          const temp = theStudents.studentDetails;
          temp.splice(0,1);
          const tempB = theButtons.buttons
          tempB[1].class="active";
          setButtons({
            buttons : tempB,
          })
          setStudents({
            studentDetails: temp
          })
          console.log(other);
        }
      }
    ]
  })

  return (
    <Grid container direction="column">
      <Grid container>
        {theButtons.buttons.map((button,index)=>{
          return (
            <Button uniq={button.id} key={button.id} onClick={(event)=>button.onClickFun(event,button.id)} className={classes[button.class]+" "+classes.button}>
              {button.name}
            </Button>
          )
        })}
      </Grid>
      {theStudents.studentDetails.map((student, index) => {
        return (
          <Grid item key={index}>
            {student.name}; {student.interests.join(", ")}; {student.age}
          </Grid>
        );
      })}
    </Grid>
  );
};

export default LearnFilter;
