using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Pi : Constant
    {
        public override double Evaluate()
        {
            return Math.PI;
        }

        public override string Result()
        {
            return "Pi";
        }
    }
}
