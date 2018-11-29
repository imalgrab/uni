using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public abstract class Expression
    {
        public abstract double Evaluate();

        public abstract string Result();
    }
}
