using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculator
{
    public partial class CalculatorValueForVariables : Form
    {
        public double varValue { get; set; }
        public CalculatorValueForVariables()
        {
            InitializeComponent();
        }

        private void varValEntry_Click(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            textBoxVarValue.Text += button.Text;
        }

        private void btnVarValueEnter_Click(object sender, EventArgs e)
        {
            this.varValue = Double.Parse(textBoxVarValue.Text);
            this.DialogResult = DialogResult.OK;
            this.Close();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if(textBoxVarValue.Text.Length > 0)
            {
                textBoxVarValue.Text = textBoxVarValue.Text.Remove(textBoxVarValue.Text.Length - 1);
            }
        }

        private void btnComma_Click(object sender, EventArgs e)
        {
            Button button = (Button)sender;

            if(!(button.Text.Equals(",") && textBoxVarValue.Text.Contains(",")))
            {
                textBoxVarValue.Text += button.Text;
            }
        }

        private void btnNeg_Click(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            if(!(button.Text.Equals("-") && textBoxVarValue.Text.Contains("-")))
            {
                if (textBoxVarValue.Text.Equals(""))
                {
                    textBoxVarValue.Text += "-";
                }
                else
                {
                    textBoxVarValue.Text = "-" + textBoxVarValue.Text;
                }
            }
        }
    }
}