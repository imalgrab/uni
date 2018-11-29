using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class E : Constant
    {
        public override double Evaluate()
        {
            return Math.E;
        }

        public override string Result()
        {
            return "e";
        }
    }
}
